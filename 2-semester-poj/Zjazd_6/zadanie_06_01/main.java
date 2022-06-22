/*
Summary: Main Class to rule them all!
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_01;

public class main {
    public static void main(String[] args) {
        System.out.println("Class MovablePoint");
        MovablePoint mpkt = new MovablePoint(2, 2, 1, 1);
        System.out.println(mpkt.toString());
        mpkt.moveRight();
        mpkt.moveUP();
        System.out.println(mpkt.toString());
        System.out.println("");

        System.out.println("Class MovableRectangle");
        MovableRectangle mrect = new MovableRectangle(3, 3, 6, 6, 2, 2);
        System.out.println(mrect.toString());
        mrect.moveDown();
        System.out.println(mrect.toString());
        mrect.moveRight();
        System.out.println(mrect.toString());
        System.out.println("");
    }
}
