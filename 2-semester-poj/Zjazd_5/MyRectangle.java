/*
Summary: Exercise 05_04 UML CHART MyRectangle Class construction
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_5;

public class MyRectangle {
    private MyPoint corner1;
    private MyPoint corner2;

    public MyRectangle(MyPoint corner1, MyPoint corner2) {
        this.corner1 = corner1;
        this.corner2 = corner2;
    }

    public MyRectangle(int x1, int y1, int x2, int y2) {
        this.corner1 = new MyPoint(x1,y1);
        this.corner2 = new MyPoint(x2,y2);
    }

    public MyPoint getCorner1() {
        return corner1;
    }

    public void setCorner1(MyPoint corner1) {
        this.corner1 = corner1;
    }

    public MyPoint getCorner2() {
        return corner2;
    }

    public void setCorner2(MyPoint corner2) {
        this.corner2 = corner2;
    }

    public double getPerimeter() {
//        double distance1 = Math.sqrt(Math.pow(this.corner1.getX() - this.corner2.getX(), 2));
//        double distance2 = Math.sqrt(Math.pow(this.corner1.getY() - this.corner2.getY(), 2));
        double distance1 = corner1.distance(corner2.getX(), corner1.getY());
        double distance2 = corner1.distance(corner1.getX(), corner2.getY());
        return distance1*2 + distance2*2;
    }

    public double getArea() {
//        double distance1 = Math.sqrt(Math.pow(this.corner1.getX() - this.corner2.getX(), 2));
//        double distance2 = Math.sqrt(Math.pow(this.corner1.getY() - this.corner2.getY(), 2));
        double distance1 = corner1.distance(corner2.getX(), corner1.getY());
        double distance2 = corner1.distance(corner1.getX(), corner2.getY());
        return distance1*distance2;
    }

    @Override
    public String toString() {
        return "MyRectangle\n{" +
                "corner1=" + corner1 +
                ",\n corner2=(" + corner2.getX() +"," + corner1.getY() +
                "),\n corner3=(" + corner1.getX() + "," + corner2.getY()+
                "),\n corner4=" + corner2+
                '}';
    }
}
