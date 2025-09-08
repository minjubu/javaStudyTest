package com.ohgiraffers.chap04controlflow.level02.normal;

import java.util.Scanner;

public class Normal4 {
    public void test4() {
        /* 반복문을 이용하여 알파벳 소문자 'a'부터 'z'까지를 개행 없이 차례로 출력하세요
         *
         * -- 출력 예시 --
         * abcdefghijklmnopqrstuvwxyz
         * */
        char min = 'a';
        char max = 'z';

        for (int i = min; i <= max; i++) {
            System.out.print((char)i);
        }

    }
}
