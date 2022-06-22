/*
Summary: Exercise 06_04 Athlete Class construction
        Implements Runner Interface
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_04;


import static java.lang.Thread.sleep;

public class Athlete implements Runner {
    private String name;

    public Athlete(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("My name is: " + this.name + " and I'm about to run a marathon!");
            sleep(1500);
            System.out.println("Ready");
            sleep(1000);
            System.out.println("Steady");
            sleep(2500);
            System.out.println("Go!");
            for (int i = 0; i < 10; i++) {
                sleep(1234);
                if (i < 9) {
                    System.out.print("_");
                } else if (i == 9) {
                    System.out.print("|");
                    sleep(1500);
                }
            }
            System.out.println(" FINISH LINE! ");
        } catch (Exception e) {
            System.out.println("Oops Something went wrong");
            ;
        }


    }
}
