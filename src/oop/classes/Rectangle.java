package oop.classes;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle(double side) {
        this.sideA = side;
        this.sideB = side;
    }

    public Rectangle() {
        this.sideA = 4;
        this.sideB = 3;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    double area() {
        return this.sideA * this.sideB;
    }

    double perimeter() {
        return 2 * (this.sideA + this.sideB);
    }

    boolean isSquare() {
        return this.sideA == this.sideB;
    }

    void replaceSides() {
        double tempA = this.sideA;
        this.sideA = this.sideB;
        this.sideB = tempA;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}