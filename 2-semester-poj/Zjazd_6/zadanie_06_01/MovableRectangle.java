/*
Summary: Exercise 06_01 UML CHART MovableRectangle Class construction
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_01;

public class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    @Override
    public String toString() {
        return "MovableRectangle[" +
                "topLeft=(x=" + topLeft.x +", y=" + topLeft.y +
                "), bottomRight=(x=" + bottomRight.x +", y=" + bottomRight.y +
                ")]";
    }

    @Override
    public void moveUP() {
        this.topLeft.y -= topLeft.ySpeed;
        this.bottomRight.y -= bottomRight.ySpeed;
    }

    @Override
    public void moveDown() {
        this.topLeft.y += topLeft.ySpeed;
        this.bottomRight.y += bottomRight.ySpeed;
    }

    @Override
    public void moveLeft() {
        this.topLeft.x -= topLeft.xSpeed;
        this.bottomRight.x -= bottomRight.xSpeed;
    }

    @Override
    public void moveRight() {
        this.topLeft.x += topLeft.xSpeed;
        this.bottomRight.x += bottomRight.xSpeed;
    }
}
