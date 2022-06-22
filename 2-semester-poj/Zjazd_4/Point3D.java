/*
Summary: Exercise 21 UML CHART Point3D Subclass extends Point2D Class
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_4;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x,y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] result = {super.getX(), super.getY(), z};
        return result;
    }

    @Override
    public String toString() {
        return "("+super.getX() +"," + super.getY() + "," + z+")";
    }
}
