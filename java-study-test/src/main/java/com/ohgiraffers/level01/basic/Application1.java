package com.ohgiraffers.level01.basic;

public class Application1 {
    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 30;

        int result1 = num1 + num2;
        int result2 = num1 - num2;
        int result3 = num1 * num2;
        int result4 = num1 / num2;
        int result5 = num1 % num2;

        System.out.println("더하기 결과 : " + result1);
        System.out.println("빼기 결과 : " + result2);
        System.out.println("곱하기 결과 : " + result3);
        System.out.println("나누기한 몫 : " + result4);
        System.out.println("나누기한 나머지 : " + result5);
    }
}
