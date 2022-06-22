/*
Summary: Exercise 06_08 ThrowUsedCarException Class construction
        Handles whole logic
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_08;

import java.util.ArrayList;

public class ThrowUsedCarException {
    public void ThrowUsedCarException() throws UsedCarException {
        UsedCar[] arrayCars = new UsedCar[7];
        ArrayList<UsedCar> goodCars = new ArrayList<UsedCar>();
        try {
            arrayCars[0] = new UsedCar("1234", "Focus", 1999, 999999, 15000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            arrayCars[1] = new UsedCar("0001", "Mercedes", 2010, 50000, -55000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            arrayCars[2] = new UsedCar("4909", "Ford", 1995, 666666, 2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            arrayCars[3] = new UsedCar("0909", "Toyota", 2008, 150000, 45000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            arrayCars[4] = new UsedCar("1111", "Chrysler", 1998, -500, 25000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            arrayCars[5] = new UsedCar("2222", "Golf", 2000, 234000, 54000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            arrayCars[6] = new UsedCar("3456", "Other", 2009, 35777, 5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < arrayCars.length; i++) {
            if (arrayCars[i] != null) goodCars.add(arrayCars[i]);
        }
        System.out.println(goodCars);
    }
}
