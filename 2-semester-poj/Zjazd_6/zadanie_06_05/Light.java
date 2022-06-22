/*
Summary: Exercise 06_05 Light Class construction
        Implements Turner Interface
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_05;

public class Light implements Turner {
    @Override
    public void turn() {
        System.out.println("Light's on");
    }
}
