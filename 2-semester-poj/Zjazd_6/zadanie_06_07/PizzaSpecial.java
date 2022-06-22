/*
Summary: Exercise 06_07 PizzaSpecial Class construction
        Extends Pizza
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_07;

public class PizzaSpecial extends Pizza {
    private int diameter;
    private String specialIngredient;
    private boolean isVegeterian;

    public PizzaSpecial(double calories, String name, double price) {
        super(calories, name, price);
    }

    public PizzaSpecial(double calories, String name, double price, int diameter, String specialIngredient, boolean isVegeterian) {
        super(calories, name, price);
        this.diameter = diameter;
        this.specialIngredient = specialIngredient;
        this.isVegeterian = isVegeterian;
    }

    public int getDiameter() {
        return diameter;
    }

    public String getSpecialIngredient() {
        return specialIngredient;
    }

    public boolean isVegeterian() {
        return isVegeterian;
    }
}
