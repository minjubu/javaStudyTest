package com.ohgiraffers.chap09api.level01.basic;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder =  new StringBuilder();

        System.out.print("문자열 입력 : ");
        String sb = sc.nextLine();
        String[] sarr = sb.split(" ");
        for(String str : sarr){
            System.out.print(str);
        }

    }
}
