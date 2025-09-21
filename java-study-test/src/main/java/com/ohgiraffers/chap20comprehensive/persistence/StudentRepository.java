package com.ohgiraffers.chap20comprehensive.persistence;

import com.ohgiraffers.chap20comprehensive.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final StudentStorage studentStorage;
    private final List<Student> studentsList;

    public StudentRepository(StudentStorage studentStorage) {
        this.studentStorage = studentStorage;
        this.studentsList = studentStorage.loadStudents();
    }

    public List<Student> selectAllStudents() { return new ArrayList<>(studentsList); }

    public Student selectStudentByStudentId(int studentId) {
        return studentsList.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null);
    }

    public void insertStudent(Student student) {
        studentsList.add(student);
        studentStorage.saveStudent(studentsList);
    }

    public void deleteStudent(int studentId) {
        studentsList.removeIf(s -> s.getStudentId() == studentId);
        studentStorage.saveStudent(studentsList);
    }

    public void updateStudent(Student updatedstudent) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getStudentId() == updatedstudent.getStudentId()) {
                studentsList.set(i, updatedstudent);
                studentStorage.saveStudent(studentsList);
                break;
            }
        }
    }
}
