/*
Summary: Exercise 05_02 UML CHART MyCircle Class construction
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_5;

public class MyCircle {
    private MyPoint center;
    private int radius;

    public MyCircle() {
        center = new MyPoint(0,0);
        int radius = 1;
    }

    public MyCircle(int x, int y, int radius) {
        center = new MyPoint(x,y);
        this.radius = radius;
    }

    public MyCircle(MyPoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public MyPoint getCenter() {
        return center;
    }

    public void setCenter(MyPoint center) {
        this.center = center;
    }

    public int getCenterX() {
        return center.getX();
    }

    public void setCenterX(int x) {
        this.center.setX(x);
    }

    public int getCenterY() {
        return center.getY();
    }

    public void setCenterY(int y) {
        this.center.setY(y);
    }

    public int[] getCenterXY() {
        return center.getXY();
    }

    public void setCenterXY(int x, int y) {
        this.center.setXY(x,y);
    }

    @Override
    public String toString() {
        return "MyCircle[" +
                "radius=" + this.radius +
                ",center=" + this.center.toString() +
                "]";
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public double distance(MyCircle anotherObject) {
        return center.distance(anotherObject.getCenter());
    }
}
