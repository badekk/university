/*
Summary: Exercise 06_03 Life SubClass construction
        Extends Abstract Insurance Class
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_03;


public class Life extends Insurance {
    public Life() {
        super("Life");
        setCost();
    }

    @Override
    public void setCost() {
        this.monthlyPrice = 36;
    }

    @Override
    public void display() {
        System.out.printf("Insurance: %s \nCosts: $%.2f per month\n", this.insuranceType, this.monthlyPrice);
    }

}
