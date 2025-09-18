package com.ohgiraffers.chap08polymorphism.level01.basic;

public class Circle extends Shape implements Resizable  {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void resize(double factor) {
        radius *= factor;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
