/*
Summary: Main Class to rule them all!
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_5;

import java.io.IOException;
import java.util.function.DoubleToIntFunction;

public class main {
    public static void main(String[] args) {
        System.out.println("Class MyPoint");
        MyPoint point1 = new MyPoint(5,5);
        MyPoint point2 = new MyPoint(1,4);
        System.out.println(point1.distance(10,10));
        System.out.println(point1.distance());
        System.out.println(point2.distance(point1));
        System.out.println(point1.distance(point2));
        System.out.println(point1.toString());

        System.out.println("Class MyCircle");
        MyCircle c1 = new MyCircle(new MyPoint(5,5), 10);
        MyCircle c2 = new MyCircle(2,3,5);
        System.out.println(c1.getArea());
        System.out.println(c2.getArea());
        System.out.println(c1.getCircumference());
        System.out.println(c2.getCircumference());
        System.out.println(c1.distance(c2));
        System.out.println(c1.toString());

        System.out.println("Class MyTriangle");
        MyTriangle t1 = new MyTriangle(1,2,3,4,5,6);
        MyTriangle t2 = new MyTriangle(0,8,1,3,2,7);
        System.out.println(t1.getPerimeter());
        System.out.println(t2.getPerimeter());
        System.out.println(t1.getType());
        System.out.println(t2.getType());
        System.out.println(t1.toString());

        System.out.println("Class MyRectangle");
        MyRectangle r1 = new MyRectangle(2,1,3,6);
        System.out.println(r1.getPerimeter());
        System.out.println(r1.getArea());
        System.out.println(r1.toString());

        System.out.println("Class Customer");
        Customer client1 = new Customer(1, "Pablito",25);
        System.out.println(client1.getDiscount());
        System.out.println(client1.toString());

        System.out.println("Class Invoice");
        Invoice inv1 = new Invoice(1 ,new Customer(1, "Pablites", 25), 1000);
        System.out.println(inv1.getAmount());
        System.out.println(inv1.getCustomer());
        System.out.println(inv1.getCustomerName());
        System.out.println(inv1.getAmountAfterDiscount());

        System.out.println("Class ChemicalElement");
        ChemicalElement elem1 = new ChemicalElement("Hydrogen", "H",1);
        ChemicalElement elem2 = new ChemicalElement("Oxygen", "O",8);
        ChemicalElement elem3 = new ChemicalElement("Potassium", "K",19);
        ChemicalElement elem4 = new ChemicalElement("Zinc", "Zn",30);
        ChemicalElement elem5 = new ChemicalElement("Gallium", "Ga",31);
        System.out.println(elem1.toString());
        System.out.println(elem2.toString());
        System.out.println(elem3.toString());
        System.out.println(elem4.toString());
        System.out.println(elem5.toString());

        GradesStatistics test = new GradesStatistics();
        test.GradeStatistics();
    }
}
