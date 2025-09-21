package com.ohgiraffers.chap20comprehensive.persistence;

import com.ohgiraffers.chap20comprehensive.domain.Student;

import java.util.List;

public interface StudentStorage {
    void saveStudent(List<Student> students);
    List<Student> loadStudents();
}
