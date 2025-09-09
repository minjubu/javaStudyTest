package com.ohgiraffers.chap05array.level04.advanced;

import java.util.Random;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int[] iarr = new int[4];

        for (int i = 0; i < iarr.length; i++) {
            int num = rand.nextInt(9);
            boolean duplicate = false;

            for (int j = 0; j < i; j++) {
                if (iarr[j] == num) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
            }
            System.out.print(iarr[i]);
        }
    }
}