package com.ohgiraffers.level02.normal;

import java.util.Random;

public class RandomMaker {
    public static int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }



    public static String rockPaperScissors() {
        String[] choices = {"가위" , "바위", "보"};
        Random random = new Random();
        int choice = random.nextInt(choices.length);
        return choices[choice];
    }

    public static String tossCoin() {
        String[] choices = {"앞면", "뒷면"};
        Random random = new Random();
        int choice = random.nextInt(choices.length);
        return choices[choice];
    }

}
