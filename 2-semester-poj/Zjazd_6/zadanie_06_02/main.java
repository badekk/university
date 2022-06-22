/*
Summary: Main Class to rule them all!
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_02;

public class main {
    public static void main (String[] args) {
        System.out.println("Class Circle");
        Circle crc = new Circle(5);
        System.out.println(crc.radius);
        System.out.println(crc.getArea());
        System.out.println(crc.getPerimeter());
        System.out.println("");

        System.out.println("Class ResizableCircle");
        ResizableCircle recrc = new ResizableCircle(10);
        System.out.println(recrc.getRadius());   //checking radius
        System.out.println(recrc.getArea());
        System.out.println(recrc.getPerimeter());
        recrc.resize(50); //resizing radius by 50%
        System.out.println(recrc.getRadius());  //checking if radius has been changed
        System.out.println(recrc.getArea());  // new getArea with new radius
        System.out.println(recrc.getPerimeter());  // new getPerimeter with new radius
    }
}
