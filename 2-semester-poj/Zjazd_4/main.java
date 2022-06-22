/*
Summary: Main class - to operate them all classes :)
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_4;

import Zadania.Zjazd_3.Company;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        System.out.println("Person Class");
        Person man1 = new Person("Pawel","Gdansk");
        System.out.println(man1.toString());

        System.out.println("Student Class");
        Student man2 = new Student("Piotr","Gdynia", "Informatyka",2020,90000);
        System.out.println(man2.toString());

        System.out.println("Staff Class");
        Staff man3 = new Staff("Zdislaw","Warszawa","WAT",1000000);
        System.out.println(man3.toString());

        System.out.println("Point2D Class");
        Point2D pt1 = new Point2D(5,10);
        System.out.println(pt1.toString());

        System.out.println("Point3D Class");
        Point3D pt2 = new Point3D(8,10,30);
        System.out.println(pt2.toString());

        System.out.println("Point Class");
        Point point1 = new Point(15,20);
        System.out.println(point1.toString());

        System.out.println("MovablePoint Class");
        MovablePoint point2 = new MovablePoint(10,90);
        MovablePoint point3 = new MovablePoint(5,2,15,20);
        System.out.println(point2.move());
        System.out.println(point3.move());
        //System.out.println(point2.toString());
        //System.out.println(point3.toString());

        System.out.println("Shape Class");
        Shape shape1 = new Shape("green", true);
        System.out.println(shape1.toString());

        System.out.println("Circle Class");
        Circle shape2 = new Circle(5);
        System.out.println(shape2.toString());
        System.out.println(shape2.getArea());
        System.out.println(shape2.getPerimeter());

        System.out.println("Rectangle Class");
        Rectangle shape3 = new Rectangle(5, 10);
        System.out.println(shape3.toString());
        System.out.println(shape3.getArea());
        System.out.println(shape3.getPerimeter());

        System.out.println("Square Class");
        Square shape4 = new Square(5);
        System.out.println(shape4.getArea());
        System.out.println(shape4.getPerimeter());
        System.out.println(shape4.toString());

        System.out.println("Armstrong Class");
        ArmStrong arm1 = new ArmStrong();
        System.out.println(arm1.ArmStrong(371));
        System.out.println(arm1.ArmStrong(502));
        System.out.println(arm1.ArmStrongv2(371));
        System.out.println(arm1.ArmStrongv2(317));

        System.out.println("DifferentWords Class");
        DifferentWords word = new DifferentWords();
        word.DifWords("lol.txt");

        System.out.println("Exercise 26 CLASS");
        CountWords counting = new CountWords();
        counting.CountWords("lol.txt");
        System.out.println("What is most frequent word in Shakespeare's Hamlet = the=992");


    }
}
