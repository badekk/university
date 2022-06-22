/*  Summary: Main class - to operate them all classes :)
    Author: Badysiak Paweł s21166
 */


package Zadania.Zjazd_2;

public class main {
    public static void main(String[] args){
        System.out.println("Class Human");
        Human myData = new Human(28,90,184, "Pawel", "male", "s21166", 45);
        System.out.println(myData.toString());

        System.out.println("Class Rectangle");
        Rectangle R = new Rectangle(10, 20);
        System.out.println(R.getRectangleArea());
        System.out.println(R.getRectangleCircuit());
        System.out.println(R.getRectangleDiagonal());

        System.out.println("Class Triangle");
        Triangle myTriangle = new Triangle(5, 5, 5);
        System.out.println(myTriangle.getTriangleCircuit());
        System.out.println(myTriangle.getTriangleArea());
        System.out.println(myTriangle.isEquilateral());
        System.out.println(myTriangle.isIsosceles());
        System.out.println(myTriangle.isScalene());

        System.out.println("CESAR Cryptography");
        Cesar code = new Cesar(20);
        System.out.println(code.getPassword("Pawel Badysiak"));
        System.out.println(code.getFix("juqyf vuxsmcue"));
    }
}
