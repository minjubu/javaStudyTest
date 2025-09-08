package com.ohgiraffers.chap04controlflow.level03;

import java.util.Scanner;

public class Hard5 {
    public void hard5() {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열 입력 : ");
        String name = sc.nextLine();

        boolean valid = true;
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if(!(ch >= 'A' && ch <= 'Z') || ch >= 'a' && ch <= 'z') {
                valid = false;
                break;
            }
        }

        if(!valid) {
            System.out.println("영문자가 아닌 문자가 포함되어 있습니다.");
            return;
        }

        System.out.println("문자 입력 : ");
        String a = sc.nextLine();
    }
}
