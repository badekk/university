/*  Summary: Excercise 8 Cesar Cypher and Decypher
    Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_2;

public class Cesar {
    private int changeBy;

    public Cesar(int changeBy) {
        this.changeBy = changeBy;
    }

    public String getPassword(String password) {
        String result = "";
        int length = password.length();

        char passwordArray[] = password.toLowerCase().toCharArray();

        for (int i = 0; i < length; i++) {
            if (passwordArray[i] == ' ') {
                result += (char) ' ';
            } else if (passwordArray[i] + changeBy <= 'z') {
                result += (char) (passwordArray[i] + changeBy);
            } else if (passwordArray[i] + changeBy > 'z') {
                int difference = ((passwordArray[i] + changeBy) - 'z') - 1; // magic, that need to happen to work gud
                result += (char) ('a'  + difference);
            }
        }
        return result;
    }
    public String getFix(String password) {
        StringBuilder result = new StringBuilder();
        int length = password.length();

        char[] passwordArray = password.toLowerCase().toCharArray();

        for (int i = 0; i < length; i++) {
            if (passwordArray[i] == ' ') {
                result.append(' ');
            } else if (passwordArray[i] - changeBy >= 'a') {
                result.append((char) (passwordArray[i] - changeBy));
            } else if (passwordArray[i] - changeBy < 'a') {
                int difference = ((passwordArray[i] - changeBy) - 'a') + 1; // magic, that need to happen to work gud
                result.append((char) ('z' + difference));
            }
        }
        return result.toString();
    }
}
