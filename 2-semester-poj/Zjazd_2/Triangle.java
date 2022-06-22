/*  Summary: Excercise 7 Triangle | Field Area | Circuit | Equilateral, Isoscales, Scalene
    Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_2;

public class Triangle {
    private float arm1;
    private float arm2;
    private float base;

    // Equilateral - równoboczny
    // Isosceles - równoramienny
    // Scalene - różnoboczny

    public Triangle(float arm1, float arm2, float base) {
        this.arm1 = arm1;
        this.arm2 = arm2;
        this.base = base;
    }

    public float getTriangleCircuit() {
        return (this.arm1 + this.arm2 + this.base);
    }

    public float getTriangleArea() {
        float circuit = this.getTriangleCircuit();
        float p = circuit / 2;

        return (float) (Math.sqrt(p*(p - this.arm1) * (p - this.arm2) * (p - this.base)));
    }

    public boolean isEquilateral() {
        return arm1 == arm2 && arm2 == base;
    }

    public boolean isIsosceles() {
        return arm1==arm2;
    }

    public boolean isScalene() {
        return arm1 != arm2 && arm1 != base && arm2 != base;
    }


}