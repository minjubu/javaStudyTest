package com.ohgiraffers.chap20comprehensive.ui;

import com.ohgiraffers.chap20comprehensive.check.CheckStudent;
import com.ohgiraffers.chap20comprehensive.domain.Student;
import com.ohgiraffers.chap20comprehensive.domain.Subject;
import com.ohgiraffers.chap20comprehensive.domain.SubjectScore;
import com.ohgiraffers.chap20comprehensive.persistence.FileStudentStorage;
import com.ohgiraffers.chap20comprehensive.persistence.StudentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/* 학생별 평균 점수 , 등수
* 과목별 평균 점수
* 반별 평균 점수 , 등수
* */

public class Application {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository(new FileStudentStorage());
        CheckStudent checkStudent = new CheckStudent(studentRepository);

        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\n===== 학생 관리 프로그램 =====");
            System.out.println("1. 학생 등록");
            System.out.println("2. 전체 학생 조회");
            System.out.println("3. 학생 ID로 조회");
            System.out.println("4. 학생 수정");
            System.out.println("5. 학생 삭제");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택: ");

            int menu = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (menu) {
                case 1: // 학생 등록
                    System.out.print("학년 입력: ");
                    int grade = sc.nextInt();
                    System.out.print("반 입력: ");
                    int classroom = sc.nextInt();
                    System.out.print("학번 입력: ");
                    int studentId = sc.nextInt();
                    sc.nextLine(); // 버퍼 비우기
                    System.out.print("이름 입력: ");
                    String name = sc.nextLine();

                    // 간단히 국어/수학 점수 입력받기 (원하면 확장 가능)
                    System.out.print("국어 점수 입력: ");
                    int korean = sc.nextInt();
                    System.out.print("수학 점수 입력: ");
                    int math = sc.nextInt();
                    System.out.print("영어 점수 입력: ");
                    int english = sc.nextInt();
                    System.out.print("과학 점수 입력: ");
                    int science = sc.nextInt();


                    List<SubjectScore> scores = Arrays.asList(
                            new SubjectScore(Subject.KOREAN, korean),
                            new SubjectScore(Subject.MATH, math),
                            new SubjectScore(Subject.ENGLISH, english),
                            new SubjectScore(Subject.SCIENCE, science)
                    );

                    Student newStudent = new Student(grade, classroom, studentId, name, scores);

                    try {
                        checkStudent.registerStudent(newStudent);
                        System.out.println("학생 등록 완료!");
                    } catch (Exception e) {
                        System.out.println("등록 실패: " + e.getMessage());
                    }
                    break;

                case 2: // 전체 학생 조회
                    checkStudent.findAllStudents().forEach(System.out::println);
                    break;

                case 3: // ID로 학생 조회
                    System.out.print("조회할 학생 ID 입력: ");
                    int searchId = sc.nextInt();
                    Student found = checkStudent.findStudentByStudentId(searchId);
                    System.out.println(found != null ? found : "해당 학생 없음");
                    break;

                case 4: // 학생 수정
                    System.out.print("수정할 학생 ID 입력: ");
                    int modifyId = sc.nextInt();
                    sc.nextLine();

                    Student exist = checkStudent.findStudentByStudentId(modifyId);
                    if (exist == null) {
                        System.out.println("학생 없음");
                        break;
                    }

                    System.out.print("새로운 국어 점수: ");
                    int newKor = sc.nextInt();
                    System.out.print("새로운 수학 점수: ");
                    int newMath = sc.nextInt();
                    System.out.print("새로운 영어 점수: ");
                    int newEng = sc.nextInt();
                    System.out.print("새로운 과학 점수: ");
                    int newSci = sc.nextInt();

                    List<SubjectScore> newScores = Arrays.asList(
                            new SubjectScore(Subject.KOREAN, newKor),
                            new SubjectScore(Subject.MATH, newMath),
                            new SubjectScore(Subject.ENGLISH, newEng),
                            new SubjectScore(Subject.SCIENCE, newSci)
                    );

                    Student updated = new Student(exist.getGrade(), exist.getClassroom(), exist.getStudentId(), exist.getName(), newScores);

                    try {
                        checkStudent.modifyStudent(updated);
                        System.out.println("학생 정보 수정 완료!");
                    } catch (Exception e) {
                        System.out.println("수정 실패: " + e.getMessage());
                    }
                    break;

                case 5: // 학생 삭제
                    System.out.print("삭제할 학생 ID 입력: ");
                    int deleteId = sc.nextInt();
                    try {
                        checkStudent.removeStudent(deleteId);
                        System.out.println("학생 삭제 완료!");
                    } catch (Exception e) {
                        System.out.println("삭제 실패: " + e.getMessage());
                    }
                    break;

                case 0: // 종료
                    run = false;
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }

        sc.close();
        System.out.println("프로그램 종료");
    }

}



