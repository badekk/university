/*
Summary: Exercise 23 UML CHART Rectangle SubClass extends Shape Class
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_4;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return length*width;
    }

    public double getPerimeter() {
        double doubleLength = length + length;
        double doubleWidth = width + width;
        return doubleLength + doubleWidth;
    }

    @Override
    public String toString() {
        return "Rectangle[Shape{" +
                "color=" + super.getColor() +
                ", filled=" + super.isFilled() +
                "},width=" + width +
                ", length=" + length +
                '}';
    }
}
