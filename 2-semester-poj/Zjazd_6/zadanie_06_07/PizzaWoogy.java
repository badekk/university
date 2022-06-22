/*
Summary: Exercise 06_07 PizzaWoogy Class construction
        Extends Pizza
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_07;

public class PizzaWoogy extends Pizza {
    private int diameter;
    private String woogyIngredient;
    private boolean isVegeterian;

    public PizzaWoogy(double calories, String name, double price) {
        super(calories, name, price);
    }

    public PizzaWoogy(double calories, String name, double price, int diameter, String woogyIngredient, boolean isVegeterian) {
        super(calories, name, price);
        this.diameter = diameter;
        this.woogyIngredient = woogyIngredient;
        this.isVegeterian = isVegeterian;
    }

    public int getDiameter() {
        return diameter;
    }

    public String getWoogyIngredient() {
        return woogyIngredient;
    }

    public boolean isVegeterian() {
        return isVegeterian;
    }
}
