/*
Summary: Exercise 06_04 DemoRunners Class construction
        Object construction and usage
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_04;


import java.util.Scanner;

public class DemoRunners {
    public void DemoRunners() {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("0")) {
            System.out.println("Check each Runner!");
            System.out.println("[1]. Athlete \n[2]. Machine\n[3]. Political Candidate");
            System.out.println("or press [0]. to Exit");
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    Athlete athlete = new Athlete("Pablito Sanchez");
                    athlete.run();
                    break;
                case "2":
                    Machine mech = new Machine("Tea");
                    mech.run();
                    break;
                case "3":
                    PoliticalCandidate polcan = new PoliticalCandidate("Trump");
                    polcan.run();
                    break;
                case "0":
                    System.out.println("Farewell!");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

    }
}

