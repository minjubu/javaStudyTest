package com.ohgiraffers.chap05array.level04.advanced;

import java.util.Arrays;
import java.util.Random;

public class Application1 {
    public static void main(String[] args) {
        Random random = new Random();

        int[] iarr = new int[6];

        for (int i = 0; i < iarr.length; i++) {
            int num = random.nextInt(45) + 1;
           boolean duplicate = false;

            for (int j = 0; j < i; j++) {
                if (iarr[j] == num) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                i--;
            } else {
                iarr[i] = num;
            }
        }
        Arrays.sort(iarr);
        System.out.println("로또 번호 : " + Arrays.toString(iarr));
    }
}
