/*  Summary: Exercise 17  Palindrome checker
    Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_3;

import java.util.*;

public class Palindrom {

    public boolean isPalindrom(String password) {
        ArrayList<String> initial = new ArrayList<String>();
        ArrayList<String> after = new ArrayList<String>();
        password = password.replaceAll("([^a-zA-ZąĄćĆęĘóÓśŚłŁńŃżŻźŹ]|\\s)+","");

        int length = password.length();
        for(String letter: password.split("")){
            initial.add(letter);
            after.add(letter);
        }
        //Reverse whole arrayList with password
        Collections.reverse(after);

        //For that itereates over whole password and compares
        //each letter with reversed password
        for(int i = 0; i<length; i++) {
            if(!(initial.get(i).equalsIgnoreCase(after.get(i))))
                return false;
        }
        return  true;
    }
}
