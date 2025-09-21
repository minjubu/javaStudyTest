package com.ohgiraffers.chap20comprehensive.check;

import com.ohgiraffers.chap20comprehensive.domain.Student;
import com.ohgiraffers.chap20comprehensive.persistence.StudentRepository;

import java.util.List;

public class CheckStudent {
    private final StudentRepository studentRepository;
    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 100;
    private static final int MIN_CLASSROOM = 1;
    private static final int MAX_CLASSROOM = 8;
    private static final int MIN_GRADE = 1;
    private static final int MAX_GRADE = 6;

    public CheckStudent(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllStudents() {
        return studentRepository.selectAllStudents();
    }

    public Student findStudentByStudentId(int studentId) {
        return studentRepository.selectStudentByStudentId(studentId);
    }

    public void registerStudent(Student student) {
        if (isDuplicateStudentId(student.getStudentId())){
            throw new IllegalStateException("이미 등록 된 학생입니다.");
        }

        validateStudent(student);
        studentRepository.insertStudent(student);
    }

    public void removeStudent(int studentId) {
        Student existingStudent = studentRepository.selectStudentByStudentId(studentId);
        if (existingStudent == null) {
            throw new IllegalArgumentException("삭제 실패: 해당 학생을 찾을 수 없습니다.");
        }
        studentRepository.deleteStudent(studentId);
    }

    public void modifyStudent(Student updatedStudent) {
        Student existingStudent = studentRepository.selectStudentByStudentId(updatedStudent.getStudentId());
        if (existingStudent == null) {
            throw new IllegalArgumentException("학생 정보 수정 실패 : 해당 학생 정보가 없습니다.");
        }

        validateStudent(updatedStudent);
        studentRepository.updateStudent(updatedStudent);
    }

    private boolean isDuplicateStudentId(int studentId) {
        return studentRepository.selectAllStudents().stream()
                .anyMatch(s -> s.getStudentId() == studentId);
    }

    private void validateStudent(Student student) {
        /* 최소 과목 입력 검증 */
        if (student.getSubjectScore() == null || student.getSubjectScore().isEmpty()) {
            throw new IllegalArgumentException("최소 하나 이상의 과목 점수가 필요합니다.");
        }

        /* 점수 검증 */
        student.getSubjectScore().forEach(ss -> {
            if (ss.getScore() < MIN_SCORE || ss.getScore() > MAX_SCORE ) {
                throw new IllegalArgumentException("점수는 " + MIN_SCORE + "이상  " + MAX_SCORE + " 이하만 가능합니다.");
            }
        });
        /* 학년 검증 */
            if (student.getGrade() < MIN_GRADE || student.getGrade() > MAX_GRADE) {
                throw new IllegalArgumentException("학년은 " + MIN_GRADE + " 이상" + MAX_GRADE + "이하만 가능합니다.");
            }
        /* 반 검증 */
            if (student.getClassroom() < MIN_CLASSROOM || student.getClassroom() > MAX_CLASSROOM) {
                throw new IllegalArgumentException("반은 " + MIN_CLASSROOM + " 이상" + MAX_CLASSROOM + "이하만 가능합니다.");
            }

    }
}
