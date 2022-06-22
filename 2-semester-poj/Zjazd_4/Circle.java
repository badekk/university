/*
Summary: Exercise 23 UML CHART Circle SubClass extends Shape Class
Author: Badysiak Paweł s21166
 */

package Zadania.Zjazd_4;

import java.lang.Math.*;

public class Circle extends Shape {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return Math.PI * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[Shape{" +
                "color=" + super.getColor() +
                ", filled=" + super.isFilled() +
                ", radius=" + radius +
                '}';
    }
}
