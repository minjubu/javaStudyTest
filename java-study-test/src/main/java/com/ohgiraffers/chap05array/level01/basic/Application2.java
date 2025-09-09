package com.ohgiraffers.chap05array.level01.basic;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        String[] sarr = new String[5];
        sarr[0] = "딸기";
        sarr[1] = "바나나";
        sarr[2] = "복숭아";
        sarr[3] = "키위";
        sarr[4] = "사과";

        Scanner sc = new Scanner(System.in);
        System.out.print("0부터 4까지의 정수를 입력하세요 : ");
        int n = sc.nextInt();
        String result = "";


       switch(n) {
           case 0 : result = sarr[0]; break;
           case 1 : result = sarr[1]; break;
           case 2 : result = sarr[2]; break;
           case 3 : result = sarr[3]; break;
           case 4 : result = sarr[4]; break;
           default :
               System.out.println("준비된 과일이 없습니다."); break;
        }
        System.out.println(result);
    }
}
