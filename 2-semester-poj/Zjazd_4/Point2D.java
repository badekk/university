/*
Summary: Exercise 21 UML CHART Point2D Class construction
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_4;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
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

    public float[] getXY(){
        float[] result = {x,y};
        return result;
    }

    @Override
    public String toString() {
        return "(" +x +","+y +")";
    }
}
