/*
Summary: Exercise 06_08 ThrowUsedCarException Class construction
        Handles whole logic
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_08;

import java.util.ArrayList;
import java.util.List;

public class ThrowUsedCarException2 {
    public void ThrowUsedCarException2() throws UsedCarException {
        ArrayList<UsedCar> goodCars = new ArrayList<UsedCar>();
        addNewCarToList(goodCars, "1234", "Focus", 1999, 999999, 15000);
        addNewCarToList(goodCars, "0001", "Mercedes", 2010, 50000, -55000);
        addNewCarToList(goodCars, "4909", "Ford", 1995, 666666, 2000);
        addNewCarToList(goodCars, "0909", "Toyota", 2008, 150000, 45000);
        addNewCarToList(goodCars, "1111", "Chrysler", 1998, -500, 25000);
        addNewCarToList(goodCars, "2222", "Golf", 2000, 234000, 54000);
        addNewCarToList(goodCars, "3456", "Other", 2009, 35777, 5000);

        System.out.println(goodCars);
    }

    private void addNewCarToList(List<UsedCar> list, String vin, String made, int year, int mileage, int price) {
        try {
            list.add(new UsedCar(vin, made, year, mileage, price));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
