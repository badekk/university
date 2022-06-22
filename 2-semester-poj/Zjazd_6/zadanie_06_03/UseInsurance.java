/*
Summary: Exercise 06_03 UseInsurance Class construction
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_03;


import java.util.Scanner;

public class UseInsurance {
    public void UseInsurance() {
        System.out.println("Choose Insurance:");
        System.out.println("[1].Health \n[2].Life\n[0].To Exit Program");
        Insurance parentClass;
        String userInput = "";
        Scanner scanner = new Scanner(System.in);

        while (!userInput.equals("0")) {
            userInput = scanner.nextLine();
            if (userInput.equals("1")) {
                parentClass = new Health();
                parentClass.display();
            } else if (userInput.equals("2")) {
                parentClass = new Life();
                parentClass.display();
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
