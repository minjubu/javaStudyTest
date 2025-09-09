package com.ohgiraffers.chap05array.level02.normal;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("주민등록번호를 입력하세요 : ");
        String str = sc.nextLine();

        char[] arr = str.toCharArray();

        for (int i = 8; i < str.length(); i++) {
            arr[i] = '*';
        }
        System.out.println(arr);
    }
}
