package com.ohgiraffers.chap20comprehensive;

import com.ohgiraffers.chap20comprehensive.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentStorage implements com.ohgiraffers.chap20comprehensive.persistence.StudentStorage {
    private List<Student> storage = new ArrayList<>();

    @Override
    public void saveStudent(List<Student> students) {
        this.storage = new ArrayList<>(students); // 깊은 복사로 테스트 독립성 보장
    }

    @Override
    public List<Student> loadStudents() {
        return new ArrayList<>(storage); // 새로운 리스트 반환 (외부 변경 방지)
    }
}