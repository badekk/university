/*
Summary: Exercise 06_07 PizzaDeluxe Class construction
        Extends Pizza
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_07;

public class PizzaDeluxe extends Pizza {
    private int diameter;
    private String deluxeIngredient;
    private boolean isVegeterian;

    public PizzaDeluxe(double calories, String name, double price) {
        super(calories, name, price);
    }

    public PizzaDeluxe(double calories, String name, double price, int diameter, String deluxeIngredient, boolean isVegeterian) {
        super(calories, name, price);
        this.diameter = diameter;
        this.deluxeIngredient = deluxeIngredient;
        this.isVegeterian = isVegeterian;
    }

    public int getDiameter() {
        return diameter;
    }

    public String getDeluxeIngredient() {
        return deluxeIngredient;
    }

    public boolean isVegeterian() {
        return isVegeterian;
    }
}
