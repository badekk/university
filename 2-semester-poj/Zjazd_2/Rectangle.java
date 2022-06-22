/* Summary: Excercise 6 Rectangle | Field Area | Circuit | Diagonal Length
    Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_2;

public class Rectangle {
    private float width;
    private float length;

    public Rectangle(float width, float length) {
        this.width = width;
        this.length = length;
    }

    public float getRectangleArea() {
        return this.width * this.length;
    }

    public float getRectangleCircuit() {
        return (this.width * 2) + (this.length * 2);
    }

    public float getRectangleDiagonal() {
        float squareWidth;
        float squareLength;
        squareLength = this.length * this.length;
        squareWidth = this.width * this.width;
        return (float) Math.sqrt(((squareLength) + (squareWidth)));
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
}