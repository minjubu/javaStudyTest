package com.ohgiraffers.chap20comprehensive.check;

import com.ohgiraffers.chap20comprehensive.StudentStorage;
import com.ohgiraffers.chap20comprehensive.domain.Student;
import com.ohgiraffers.chap20comprehensive.domain.Subject;
import com.ohgiraffers.chap20comprehensive.domain.SubjectScore;
import com.ohgiraffers.chap20comprehensive.persistence.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CheckStudentTest {

    private CheckStudent checkStudent;

    @BeforeEach
    void setUp() {
        StudentRepository repository = new StudentRepository(new StudentStorage());
        checkStudent = new CheckStudent(repository);
    }

    private Student createSampleStudent(int id) {
        List<SubjectScore> scores = Arrays.asList(
                new SubjectScore(Subject.KOREAN, 90),
                new SubjectScore(Subject.MATH, 80),
                new SubjectScore(Subject.ENGLISH, 80),
                new SubjectScore(Subject.SCIENCE, 70)
        );
        return new Student(1, 2, id, "홍길동" + id, scores);
    }

    @Test
    @DisplayName("학생 등록 성공")
    void registerStudent_success() {
        Student student = createSampleStudent(1);
        assertDoesNotThrow(() -> checkStudent.registerStudent(student));
    }

    @Test
    @DisplayName("중복된 등록시 예외 처리")
    void registerStudent_duplicateId_throwsException() {
        Student s1 = createSampleStudent(1);
        Student s2 = createSampleStudent(1);
        checkStudent.registerStudent(s1);

        IllegalStateException e = assertThrows(
                IllegalStateException.class,
                () -> checkStudent.registerStudent(s2)
        );
        assertEquals("이미 등록 된 학생입니다.", e.getMessage());
    }

    @Test
    @DisplayName("점수 범위 벗어나면 예외")
    void registerStudent_invalidScore_throwsException() {
        List<SubjectScore> scores = Collections.singletonList(
                new SubjectScore(Subject.KOREAN, 150) // 잘못된 점수
        );
        Student student = new Student(1, 2, 2, "이영희", scores);

        assertThrows(IllegalArgumentException.class, () -> checkStudent.registerStudent(student));
    }

    @Test
    @DisplayName("학년 범위 벗어나면 예외")
    void registerStudent_invalidGrade_throwsException() {
        Student student = new Student(0, 2, 3, "김철수", Arrays.asList(
                new SubjectScore(Subject.KOREAN, 90)
        ));
        assertThrows(IllegalArgumentException.class, () -> checkStudent.registerStudent(student));
    }

    @Test
    @DisplayName("반 범위 벗어나면 예외")
    void registerStudent_invalidClassroom_throwsException() {
        Student student = new Student(1, 20, 4, "박민수", Arrays.asList(
                new SubjectScore(Subject.KOREAN, 90)
        ));
        assertThrows(IllegalArgumentException.class, () -> checkStudent.registerStudent(student));
    }

    @Test
    @DisplayName("학생 수정 성공")
    void modifyStudent_success() {
        Student s1 = createSampleStudent(1);
        checkStudent.registerStudent(s1);

        Student updated = new Student(1, 2, 1, "홍길동1",
                Arrays.asList(new SubjectScore(Subject.KOREAN, 100)));
        assertDoesNotThrow(() -> checkStudent.modifyStudent(updated));
    }

    @Test
    @DisplayName("학생 삭제 성공")
    void removeStudent_success() {
        Student s1 = createSampleStudent(1);
        checkStudent.registerStudent(s1);

        assertDoesNotThrow(() -> checkStudent.removeStudent(1));
    }

    @Test
    @DisplayName("없는 학생 삭제시 예외 처리")
    void removeStudent_nonExistent_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> checkStudent.removeStudent(999));
    }
}
