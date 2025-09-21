package com.ohgiraffers.chap20comprehensive.domain;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    private final int grade;
    private final int classroom;
    private final int studentId;
    private final String name;
    private final List<SubjectScore> SubjectScore;

    public Student(int grade, int classroom, int studentId, String name, List<SubjectScore> subjectScore) {
        this.grade = grade;
        this.classroom = classroom;
        this.studentId = studentId;
        this.name = name;
        SubjectScore = subjectScore;
    }

    public Student update(List<SubjectScore> SubjectScore) {
        return new Student(grade, classroom, studentId, name, SubjectScore);
    }

    public int getGrade() {
        return grade;
    }

    public int getClassroom() {
        return classroom;
    }

    public int getStudentId() {
        return studentId;
    }



    public String getName() {
        return name;
    }

    public List<SubjectScore> getSubjectScore() {
        return SubjectScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                ", classroom=" + classroom +
                ", studentId=" + studentId +
                ", name='" + name + '\'' +
                ", SubjectScore=" + SubjectScore +
                '}';
    }
}
