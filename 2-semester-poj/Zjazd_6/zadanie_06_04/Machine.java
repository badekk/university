/*
Summary: Exercise 06_04 Machine Class construction
        Implements Runner Interface
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_04;


import static java.lang.Thread.activeCount;
import static java.lang.Thread.sleep;

public class Machine implements Runner {
    private String name;

    public Machine(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Would you like some " + this.name + " ?");
            sleep(2000);
            System.out.println("I'll make some anyway");
            double timer = 500;
            StringBuilder sb = new StringBuilder("=");

            for (int i = 0; i < 10; i++) {
                sleep((long) timer);
                System.out.printf("[%-10s]\n", sb.toString());
                sb.append("=");
                timer = timer * 1.15;
            }
            System.out.println("Freshly brewed " +this.name);
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
