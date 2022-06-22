/*
Summary: Exercise 06_04 PoliticalCandidate Class construction
        Implements Runner Interface
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_04;


public class PoliticalCandidate implements Runner {
    private String name;

    public PoliticalCandidate(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("My name is " + this.name);
        System.out.println("and I will be running for president in next elections!");
    }
}
