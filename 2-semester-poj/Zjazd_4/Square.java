/*
Summary: Exercise 23 UML CHART Square SubClass extends Rectangle Class
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_4;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side,side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide(){
        return super.getLength();
    }

    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    public void setWidth(double side) {
        super.setWidth(side);
    }

    public void setLength(double side) {
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "Square[Rectangle[Shape[color=" + super.getColor() +
                ", filled=" + super.isFilled() +
                "],width=" + super.getWidth() +
                " ,length=" + super.getLength() +
                "]]";
    }
}
