/*
Summary: Exercise 06_05 DemoTurners Class construction
        Object construction and usage
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_05;

public class DemoTurners {
    public void DemoTurners() {
        System.out.println("Demonstration of TurnerInterface");
        int nextClass = 0;
        while(nextClass < 4) {
            switch(nextClass) {
                case 0:
                    Leaf lif = new Leaf();
                    System.out.print("Leaf: ");
                    lif.turn();
                    break;
                case 1:
                    Page pg = new Page();
                    System.out.print("Page: ");
                    pg.turn();
                    break;
                case 2:
                    Pancake pck = new Pancake();
                    System.out.print("Pancake: ");
                    pck.turn();
                    break;
                case 3:
                    System.out.println("That is all folks");
                    break;
            }
            nextClass++;
        }
    }
}
