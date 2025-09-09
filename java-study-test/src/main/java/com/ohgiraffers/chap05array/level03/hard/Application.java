package com.ohgiraffers.chap05array.level03.hard;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("홀수인 양의 정수를 입력하세요 : ");
        int n = sc.nextInt();

        if (n < 0 || n % 2 ==0) {
            System.out.println("양수 혹은 혹수만 입력해야 합니다.");
            return;
        }

        int[] arr = new int[n];
        int mid = (n + 1) / 2;

        for (int i = 0; i < mid; i++) {
            arr[i] = i + 1;
        }
        for (int i = mid; i < n; i++) {
            arr[i] = arr[i - 1] - 1;
            System.out.println(arr[i]);
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}



