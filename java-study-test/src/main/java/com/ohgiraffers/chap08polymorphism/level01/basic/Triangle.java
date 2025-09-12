package com.ohgiraffers.chap08polymorphism.level01.basic;

public class Triangle extends Shape implements Resizable {
    private double base;
    private double height;
    private double sid1;
    private double sid2;
    private double sid3;

    public Triangle(int base, int height, int sid1, int sid2, int sid3) {
        this.base = base;
        this.height = height;
        this.sid1 = sid1;
        this.sid2 = sid2;
        this.sid3 = sid3;
    }


    @Override
    public void resize(double factor) {
        base = base*factor;
        height = height*factor;
        sid1 = sid1*factor;
        sid2 = sid2*factor;
        sid3 = sid3*factor;
    }

    @Override
    public double calculateArea() {
        return (base * height) / 2;
    }

    @Override
    public double calculatePerimeter() {
        return sid1 + sid2 + sid3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", height=" + height +
                ", sid1=" + sid1 +
                ", sid2=" + sid2 +
                ", sid3=" + sid3 +
                '}';
    }
}

