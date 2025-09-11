package com.ohgiraffers.level01.basic.student.run;

import com.ohgiraffers.level01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentDTO[] students = new StudentDTO[10];
        int count = 0;

        while(count < students.length){
            System.out.println((count +1) +"번째 학생 정보를 입력하세요");

            System.out.print("학년 : ");
            int grade = sc.nextInt();

            System.out.print("반 : ");
            int classroom = sc.nextInt();

            System.out.print("이름 : ");
            String name = sc.next();

            System.out.print("국어점수 : ");
            int kor = sc.nextInt();

            System.out.print("영어점수 : ");
            int eng = sc.nextInt();

            System.out.print("수학점수 : ");
            int math = sc.nextInt();
            sc.nextLine();

            students[count] = new StudentDTO(grade, classroom, name, kor, eng, math);
            count++;

            System.out.print("계속 입력하시겠습니까? (y/n) : ");
            String answer = sc.next();
            if(!answer.equalsIgnoreCase("y")){
                break;
            }

        }

        System.out.println("\n====입력된 학생 정보====");
        for(int i = 0; i < count; i++){
            System.out.println(students[i].getInformation());
        }

    }
}
