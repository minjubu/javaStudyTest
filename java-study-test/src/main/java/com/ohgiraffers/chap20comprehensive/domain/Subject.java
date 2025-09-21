package com.ohgiraffers.chap20comprehensive.domain;

public enum Subject {
KOREAN, MATH, ENGLISH, SCIENCE;

    public static Subject fromString(String subject) {
        return switch (subject) {
        case "국어" -> KOREAN;
        case "수학" -> MATH;
        case "영어" -> ENGLISH;
        case "과학" -> SCIENCE;
        default -> throw new IllegalArgumentException("입력하신 " + subject + "은(는) 없는 과목입니다.");
        };
    }
}
