/*
Summary: Exercise 06_02 UML CHART Circle Class construction
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_02;

public class Circle implements GeometricObject {
    protected double radius = 1.0;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
