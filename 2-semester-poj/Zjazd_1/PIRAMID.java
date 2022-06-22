package Zadania.Zjazd_1;

import java.util.Scanner;

/*
Summary : Piramid out of alphabet made from N letters with descending mirror from the middle
Author: Pawel Badysiak
 */
public class PIRAMID {
    public static void main(String[] args) {
        int size = 0;
        int reverse = 0;
        int space = 0;
        int dck = 0;
        char letter = 'a'; // ASCII = 97 (char is int)

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give me N reasons to live");
        size = scanner.nextInt();

        space = size;

        for (int i = 1; i <= size; i++) {
            dck++;
            for (int j = 1; j <= (i + reverse); j++) {
                if (i == dck) {
                    for (int y = 0; y < space; y++) {
                        System.out.print(" ");
                    }
                }
                dck++;
                if (i <= j) {
                    System.out.print(letter);
                    letter--;
                } else {
                    System.out.print(letter);
                    letter++;
                }
            }
            dck = i;
            space--;       // decreasing number of spaces after next line iteration
            letter = 'a';  // returning letter to the starting point
            reverse++;     // increasing number of iterations of 2nd for(printing out letters) for mirroring
            System.out.println();
        }
    }
}
