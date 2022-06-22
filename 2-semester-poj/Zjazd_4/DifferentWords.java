/*
Summary: Exercise 25 - Print out different words from input file.txt
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_4;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.TreeSet;

public class DifferentWords {
    public void DifWords(String fileName) throws IOException {
        TreeSet<String> uniqueWords = new TreeSet<String>();
        try {
            FileReader fileTxt = new FileReader("C:\\" + fileName);
            StreamTokenizer streamToken = new StreamTokenizer(fileTxt);

            while (streamToken.nextToken() != StreamTokenizer.TT_EOF) {
                if (streamToken.ttype == StreamTokenizer.TT_WORD) {
                    String holder = streamToken.sval.replace(".", "").toLowerCase();
                    uniqueWords.add(holder);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(uniqueWords);
        System.out.println("Number of words: " + uniqueWords.size());
    }
}
