/*
Summary: Exercise 06_07 Menu Class construction
        Handles whole logic
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_07;

import java.util.Arrays;

public class Menu {
    public static void Menu(){
        Pizza[] arrayPizza = new Pizza[40];
        arrayPizza[0] = new PizzaWoogy(531, "Mimosini", 10000.99, 13,"Olives", true);
        arrayPizza[1] = new PizzaDeluxe(800, "Margherita", 19.99);
        arrayPizza[2] = new PizzaDeluxe(700, "Marinara", 18.99);
        arrayPizza[3] = new PizzaDeluxe(500, "Carbonara", 23.99);
        arrayPizza[4] = new PizzaDeluxe(666, "Crudo", 16.66);
        arrayPizza[5] = new PizzaDeluxe(359, "Napoli", 11.49);
        arrayPizza[6] = new PizzaDeluxe(573, "Pugliese", 16.98);
        arrayPizza[7] = new PizzaDeluxe(238, "Montanara", 15.55);
        arrayPizza[8] = new PizzaDeluxe(493, "Emiliana", 17.90);
        arrayPizza[9] = new PizzaDeluxe(960, "Romana", 18.99, 14,"Ham",false);
        arrayPizza[10] = new PizzaDeluxe(651, "Fattoria", 14.99, 15,"Pork",false);
        arrayPizza[11] = new PizzaDeluxe(514, "Schiacciata", 13.99, 13,"HamPork",false);
        arrayPizza[12] = new PizzaDeluxe(584, "Prosciutto ", 14.42, 14,"Becon",false);
        arrayPizza[13] = new PizzaDeluxe(1948, "Americana", 36.66,40,"Letuce",true);
        arrayPizza[14] = new PizzaSpecial(2800, "Margeritos", 39.99);
        arrayPizza[15] = new PizzaSpecial(3800, "Marinaros", 49.99);
        arrayPizza[16] = new PizzaSpecial(2345, "Sardos", 59.99);
        arrayPizza[17] = new PizzaSpecial(1800, "Tonnos", 69.99);
        arrayPizza[18] = new PizzaSpecial(5800, "Valtellinos", 79.99);
        arrayPizza[19] = new PizzaSpecial(2800, "Gorgonzolos", 89.99,89,"Hamster",false);
        arrayPizza[20] = new PizzaSpecial(2200, "Ortolionos", 29.99);
        arrayPizza[21] = new PizzaSpecial(1999, "Mediterranos", 99.99,90,"Fish",true);
        arrayPizza[22] = new PizzaSpecial(2333, "Calzonos", 109.99, 100,"Holy Pork",false);
        arrayPizza[23] = new PizzaSpecial(984, "Diavolos", 29.89);
        arrayPizza[24] = new PizzaSpecial(1342, "Rusticos", 40.99);
        arrayPizza[25] = new PizzaSpecial(834, "Contadinos", 33.99);
        arrayPizza[26] = new PizzaSpecial(0, "Parmigianos", 33.33);
        arrayPizza[27] = new PizzaWoogy(100, "Capriccini", 19.99, 13,"Olives", true);
        arrayPizza[28] = new PizzaWoogy(320, "Padanini", 8.99, 13,"Olives", true);
        arrayPizza[29] = new PizzaWoogy(322, "Tedesini", 7.99, 13,"Olives", true);
        arrayPizza[30] = new PizzaWoogy(334, "Tirolesini", 11.99, 13,"Olives", true);
        arrayPizza[31] = new PizzaWoogy(312, "Boscaiolini", 14.99, 13,"Olives", true);
        arrayPizza[32] = new PizzaWoogy(123, "Campagnolini", 5.99, 13,"Olives", true);
        arrayPizza[33] = new PizzaWoogy(132, "Vegetarianini", 15.99, 13,"Olives", true);
        arrayPizza[34] = new PizzaWoogy(231, "Bufalinini", 17.99, 13,"Olives", true);
        arrayPizza[35] = new PizzaWoogy(312, "Fontanini", 12.99, 13,"Olives", true);
        arrayPizza[36] = new PizzaWoogy(321, "Tricolorini", 11.99, 13,"Olives", true);
        arrayPizza[37] = new PizzaWoogy(213, "Valdostanini", 8.99, 13,"Olives", true);
        arrayPizza[38] = new PizzaWoogy(434, "Capresini", 6.99, 13,"Olives", true);
        arrayPizza[39] = new PizzaWoogy(400, "Funghini", 9.99, 13,"Olives", true);

        Arrays.sort(arrayPizza);
        for(int i = 0; i< arrayPizza.length; i++) {
            System.out.println(arrayPizza[i]);
        }

    }

}
