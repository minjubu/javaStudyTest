package com.ohgiraffers.chap05array.level03.hard;

import java.util.Random;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int rows;
        int cols;

        while (true) {
            System.out.print("가로 행의 수를 입력하세요 : ");
            rows = scanner.nextInt();
            if (rows >= 1 && rows <= 10) break;
            System.out.println("반드시 1~10까지의 정수를 입력해야합니다.");
        }

        while (true) {
            System.out.print("세로 열의 수를 입력하세요 : ");
            cols = scanner.nextInt();
            if (cols >= 1 && cols <= 10) break;
            System.out.println("반드시 1~10까지의 정수를 입력해야합니다.");
        }

        char[][] carr = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                carr[i][j] = (char)('A' +random.nextInt(26));
                // 'A'를 char 값으로 변환 한다.
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(carr[i][j] + " ");
            }
            System.out.println();
        }

    }
}