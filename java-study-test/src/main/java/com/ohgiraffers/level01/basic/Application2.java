package com.ohgiraffers.level01.basic;

public class Application2 {
    public static void main(String[] args) {
        /* 사각형의 넓이와 둘레를 구하는 문제이다.
         * 너비 12.5 높이 36.4를 변수에 저장하고
         * 각 넓이와 둘레를 계산해 변수에 담고 아래와 같이 출력되도록 하시오
         *
         * -- 출력 예시 --
         * 면적 : 455.0
         * 둘레 : 97.8
         *  */

        double wide = 12.5;
        double high = 36.4;
        double result1 = wide * high;
        double result2 = 2 * (wide + high);

        System.out.println("면적 : " + result1);
        System.out.println("둘레 : " + result2);
        System.out.println("--------------------");
        // 간결하게 표현이 가능
        System.out.println("면적 : " + (wide * high));
        System.out.println("둘레 : " + (2*(wide + high)));
    }
}
