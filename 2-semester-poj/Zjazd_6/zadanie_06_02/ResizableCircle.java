/*
Summary: Exercise 06_02 UML CHART ResizableCircle Class extends Circle construction
        and implement Resizable
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_02;

public class ResizableCircle extends Circle implements Resizable {
    public ResizableCircle(double radius) {
        super(radius);
    }

    @Override
    public void resize(int percent) {
        super.radius = (super.radius * percent) / 100 + super.radius;
    }
}
