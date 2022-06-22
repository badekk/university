/*
Summary: Exercise 06_03 Insurance AbstractClass construction
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_03;


public abstract class Insurance {
    protected String insuranceType;
    protected double monthlyPrice;

    public Insurance(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public abstract void setCost();

    public abstract void display();
}
