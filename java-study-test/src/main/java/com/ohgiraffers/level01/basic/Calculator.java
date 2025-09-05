package com.ohgiraffers.level01.basic;

public class Calculator {

    public void checkMethod(){
        System.out.println("메서드 호출 확인");
    }
    public int sum1to10(){
        return 10 * (10 + 1) / 2;
    }
    public void checkMaxNumber(int a, int b){
        System.out.println("두 수중 큰 수는 " + Math.max(a, b) + " 입니다.");
    }
    public int sumTwoNumber(int a, int b){
        return a + b;
    }
    public int minusTwoNumber(int a, int b){
        return a - b;
    }
}


