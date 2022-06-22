package Zadania.Zjazd_1;

import java.util.Scanner;

/*
Summary : Flag of Poland and Japan
Author: Pawel Badysiak
 */
public class FLAG {

    public static void main(String[] args) {
        int size = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose size of the flag: Small | Medium | Large");

        String sizeIn = scanner.nextLine();

        if (sizeIn.equalsIgnoreCase("small")) size = 6;
        else if (sizeIn.equalsIgnoreCase("medium")) size = 12;
        else size = 18;
        polishFlag(size);
        System.out.println();
        japaneseFlag(size);
    }

    public static void polishFlag(int size) {
        for (int i = 1; i < size; i++) {
            if (i <= size / 2) {
                for (int j = 0; j < 4 * size; j++) {
                    System.out.print("+");
                }
            }
            System.out.println();
            if (i >= size / 2) {
                for (int k = 0; k < 4 * size; k++) {
                    System.out.print("|");
                }
            }
        }
        System.out.println();
    }

    public static void japaneseFlag(int size) {
        int middle = 2 * size - 1;
        int stretch = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 4 * size; j++) {
                if (i > 0 && i < size - 1) {
                    if (j >= (middle - stretch) && j <= (middle + stretch + 1)) {
                        System.out.print("0");
                    } else {
                        System.out.print("-");
                    }
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
            if (i == (size / 2) - 1) ;
            else if (i < (size / 2)) stretch += 3;
            else stretch -= 3;
        }
    }
}
