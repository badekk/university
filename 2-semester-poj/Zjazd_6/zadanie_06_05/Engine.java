/*
Summary: Exercise 06_05 Engine Class construction
        Implements Turner Interface
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_05;

public class Engine implements Turner {
    @Override
    public void turn() {
        System.out.println("Engine off");
    }
}
