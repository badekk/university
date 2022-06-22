/*
Summary: Exercise 22 UML CHART MovablePoint SubClass extends Point Class
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_4;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] result = {xSpeed, ySpeed};
        return result;
    }

    public MovablePoint move() {
        float newX = super.getX() + xSpeed;
        float newY = super.getY() + ySpeed;
        super.setX(newX);
        super.setY(newY);
        return this;
    }

    @Override
    public String toString() {
        return "("+super.getX()+","+super.getY()+")"+","+"speed=("+xSpeed+","+ySpeed+")";
    }
}
