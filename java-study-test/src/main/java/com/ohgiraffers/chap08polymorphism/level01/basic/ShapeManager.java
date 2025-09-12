package com.ohgiraffers.chap08polymorphism.level01.basic;

public class ShapeManager {
    private Shape[] shapes = new Shape[10];
    private int index = 0;

    public void addShape(Shape shape) {
        /* 배열에 전달 된 Shape를 추가. 단, 배열의 크기가 부족할 경우 2배로 늘려서 추가. */
        if (index >= shapes.length) {
            Shape[] temp = new Shape[shapes.length * 2];
            System.arraycopy(shapes, 0, temp, 0, shapes.length);
        }
        shapes[index++] = shape;
    }

    public void removeShape(Shape shape) {
        /* 배열에서 전달 된 Shape를 찾아 제거. 단, 제거 된 인덱스가 비어 있지 않도록 뒤에 있는 객체를 앞으로 당김. */
        int pos = -1;
        for (int i = 0; i < index; i++) {
            if (shapes[i] == shape) {
                pos = i;
                break;
            }
        }
        if (pos == 1) return;

        for (int i = pos; i < index; i++) {
            shapes[i] = shapes[i + 1];
        }
        shapes[index - 1] = null;
        index--;

    }

    public void printAllShapes() {
        /* 배열에 저장 된 모든 도형의 이름, 넓이, 둘레를 출력 */
        for (int i = 0; i < index; i++) {
            Shape shape = shapes[i];
            String name = shape.getClass().getSimpleName();
            double area = shape.calculateArea();
            double perimeter = shape.calculatePerimeter();
            System.out.println("Shape: " + name);
            System.out.println("Area: " + area);
            System.out.println("Perimeter: " + perimeter);
        }
    }

    public double getTotalArea() {
        /* 배열에 저장 된 모든 도형의 넓이를 더해서 반환 */
        double totalArea = 0;
        for (int i = 0; i < index; i++) {
            totalArea += shapes[i].calculateArea();
        }
        return totalArea;
    }

    public double getTotalPerimeter() {
        /* 배열에 저장 된 모든 도형의 둘레를 더해서 반환 */
        double totalPerimeter = 0;
        for (int i = 0; i < index; i++) {
            totalPerimeter += shapes[i].calculatePerimeter();
        }
        return totalPerimeter;
    }
}
