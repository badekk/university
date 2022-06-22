/*
Summary: Exercise 06_08 UsedCar Class construction
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_08;
import java.util.regex.*;

public class UsedCar {
    private String vin;
    private String make;
    private int year;
    private int mileage;
    private double price;

    public UsedCar(String vin, String make, int year, int mileage, double price) throws UsedCarException {
        if (!vin.matches("\\d") && vin.length() != 4) throw new UsedCarException("Only 4 number VIN is possible");
        if (year < 1997 || year > 2017) throw new UsedCarException("Only cars beetween 1997 and 2017!");
        if (mileage < 0 || price < 0) throw new UsedCarException("No Negatives!");

        switch (make) {
            case "Ford":
            case "Honda":
            case "Toyota":
            case "Chrysler":
            case "Other":
                this.make = make;
                break;
            default:
                throw new UsedCarException("Wrong make");
        }

        this.vin = vin;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    @Override
    public String toString() {
        return "UsedCar{" +
                "[VIN]= " + vin  +
                ", [Make]= " + make +
                ", [Year]= " + year +
                ", [Mileage]= " + mileage +
                ", [Price]= " + price +
                "} \n";
    }
}
