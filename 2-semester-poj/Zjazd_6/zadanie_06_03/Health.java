/*
Summary: Exercise 06_03 Health SubClass construction
        Extends Abstract Insurance Class
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_03;

public class Health extends Insurance {

    public Health() {
        super("Health");
        setCost();
    }

    @Override
    public void setCost() {
        this.monthlyPrice = 196;
    }

    @Override
    public void display() {
        System.out.printf("Insurance: %s \nCosts: $%.2f per month\n" , this.insuranceType,this.monthlyPrice);
    }


}
