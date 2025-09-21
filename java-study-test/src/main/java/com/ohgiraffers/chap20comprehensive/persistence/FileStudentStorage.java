package com.ohgiraffers.chap20comprehensive.persistence;

import com.ohgiraffers.chap20comprehensive.domain.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStudentStorage implements StudentStorage {
    private static final String FILE_PATH = "src/main/java/com/ohgiraffers/comprehensive/db/studentDB.dat";


    @Override
    public void saveStudent(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
            oos.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException("파일 저장 중 오류 발생", e);
        }
    }

    @Override
    public List<Student> loadStudents() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return (List<Student>) ois.readObject();
        } catch (EOFException e) {
            System.out.println("학생 정보를 모두 로딩하였습니다.");
            return new ArrayList<>();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("파일 로딩 중 오류 발생", e);
        }
    }
}
