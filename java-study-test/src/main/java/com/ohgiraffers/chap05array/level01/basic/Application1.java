package com.ohgiraffers.chap05array.level01.basic;

public class Application1 {
    public static void main(String[] args) {
        int[] arr = new int[10];

        for(int i = 0; i < arr.length; i++) {
            System.out.println(i + 1);
        }

        int[] arr2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int i : arr2) {
            System.out.println(i + " ");
        }
    }
}
