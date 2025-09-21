package com.ohgiraffers.chap20comprehensive.domain;

public class SubjectScore {
    private Subject subject;
    private int score;

    public SubjectScore(Subject subject, int score) {
        this.subject = subject;
        this.score = score;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "SubjectScore{" +
                "subject=" + subject +
                ", score=" + score +
                '}';
    }
}
