/*
Summary: Exercise 05_01 UML CHART MyPoint Class construction
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_5;

public class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint() {
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        int[] result = {x, y};
        return result;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(int x, int y) {
        double distance = Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
        return distance;
    }

    public double distance(MyPoint another) {
        return distance(another.getX(), another.getY());
    }

    public double distance() {
        return distance(0, 0);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
