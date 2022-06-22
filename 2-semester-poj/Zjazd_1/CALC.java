package Zadania.Zjazd_1;

import java.util.Scanner;

/*
Summary : Calories Calculator (Harris Benedict equation)
Author: Pawel Badysiak
 */
public class CALC {
    public static void main(String[] args) {
        float weight = 0;
        float height = 0;
        int age = 0;
        String gender;

        double result = 0;

        Scanner myObj = new Scanner(System.in);
        System.out.println("Give your weight(in kilograms): ");
        weight = myObj.nextFloat();

        System.out.println("Give your height (in centimeters): ");
        height = myObj.nextFloat();

        System.out.println("Give your age: ");
        age = myObj.nextInt();

        myObj.nextLine();
        System.out.println("Now finally last one! Specify your gender m/f ");
        gender = myObj.nextLine();


        if (gender.equalsIgnoreCase("m")) {
            result = ((66.47 + (13.7 * weight) + (5.0 * height) - (6.76 * age)));
            System.out.println("You should eat: " + result + " calories");
        } else if (gender.equalsIgnoreCase("f")) {
            result = ((665.1 + (9.567 * weight) + (1.85 * height) - (4.68 * age)));
            System.out.println("You should eat: " + result + " calories");
        } else System.out.println("Wrong input kek");
    }
}
