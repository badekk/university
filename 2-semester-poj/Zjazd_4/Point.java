/*
Summary: Exercise 22 UML CHART Point Class construction
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_4;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] result = {x,y};
        return result;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
