package com.ohgiraffers.level02.normal;

public class Application2 {
    public static void main(String[] args) {
        /* 국어점수 80.5점, 수학점수 50.6점, 영어점수 70.8점을 실수 형태로 저장한 뒤
         * 총점과 평균을 정수 형태로 출력하세요
         *
         * -- 출력 예시 --
         * 총점 : 201
         * 평균 : 67
         *  */

        double dn1 = 80.5;
        double dn2 = 50.5;
        double dn3 = 70.8;
        double sum = dn1 + dn2 + dn3;
        double divide = sum / 3;
        int result = (int)sum;
        int result2 = (int)divide;

        System.out.println("총점 : " + result);
        System.out.println("평균 : " + result2);
        System.out.println("-----------------");
        // 간결하게 표현이 가능
        System.out.println("총점 : " + (int)sum);
        System.out.println("평균 : " + (int)(sum/3));
    }
}
