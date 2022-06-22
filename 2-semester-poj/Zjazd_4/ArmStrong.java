/*
Summary: Exercise 24 UML CHART number Armstrong checker
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_4;

public class ArmStrong {
    public boolean ArmStrong(int number) {
        // Creative way
        int numLength = String.valueOf(number).length();
        int moduler = 10;
        int divider = 1;
        int temp = 0;
        int result = 0;

        for (int i = 0; i < numLength; i++) {
            temp = number % moduler / divider;
            temp = temp * temp * temp;
            result += temp;
            moduler *= 10;
            divider *= 10;
        }

        return number == result;
    }

    public boolean ArmStrongv2(int number) {
        // Simplier way
        int result = 0;

        for (String s : String.valueOf(number).split("")) {
            int n = Integer.parseInt(s);
            result += n * n * n;
        }
        return result == number;
    }
}
