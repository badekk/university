/*
Summary: Exercise 06_05 DemoTurners2 Class construction
        Object construction and usage
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_05;

public class DemoTurners2 {
    public void DemoTurners2() {
        System.out.println("Demonstration of TurnerInterface");
        int nextClass = 0;
        while(nextClass < 3) {
            switch(nextClass) {
                case 0:
                    Engine eng = new Engine();
                    System.out.print("Engine: ");
                    eng.turn();
                    break;
                case 1:
                    Light lht = new Light();
                    System.out.print("Light: ");
                    lht.turn();
                    break;
                case 2:
                    System.out.println("That is all folks");
                    break;
            }
            nextClass++;
        }
    }
}
