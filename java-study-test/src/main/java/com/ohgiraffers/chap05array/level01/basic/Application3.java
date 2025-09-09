package com.ohgiraffers.chap05array.level01.basic;

public class Application3 {
    public static void main(String[] args) {
        int[][] arr = new int[3][4];
        arr[0] = new int[] { 1, 2, 3, 4 };
        arr[1] = new int[] { 5, 6, 7, 8 };
        arr[2] = new int[] { 9, 10, 11, 12 };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
