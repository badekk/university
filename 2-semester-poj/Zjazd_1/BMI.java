package Zadania.Zjazd_1;

import java.util.Scanner;
/*
Summary : BMI calculator with info
Author: Pawel Badysiak
 */

public class BMI {
    public static void main(String[] args) {
        float weight = 0;
        float height = 0;
        float bmi = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Give your weight(in kilograms): ");
        weight = scanner.nextFloat();


        System.out.println("Give your height (in centimeters): ");
        height = scanner.nextFloat();


        bmi = weight / (height / 100 * height / 100);
        if (bmi < 18.5) System.out.println("Your BMI is: " + bmi + " - underweight");
        else if (bmi <= 24.9) System.out.println("Your BMI is: " + bmi + " - right weight ");
        else if (bmi <= 29.9) System.out.println("Your BMI is: " + bmi + " - overweight ");
        else System.out.println("Your BMI is not happy: " + bmi + " - FAT - lose some weight");
    }
}
