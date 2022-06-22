/*
Summary: Exercise 26 - Print out words from input file.txt and count them
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.*;

public class CountWords {
    public void CountWords(String fileName) throws IOException {
        Map<String, Integer> wordCounts = new HashMap<>();
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        try {
            FileReader fileTxt = new FileReader("C:\\" + fileName);
            StreamTokenizer streamToken = new StreamTokenizer(fileTxt);

            while (streamToken.nextToken() != StreamTokenizer.TT_EOF) {
                if (streamToken.ttype == StreamTokenizer.TT_WORD) {
                    String holder = streamToken.sval.replace(".", "").toLowerCase();
                    if ( wordCounts.containsKey(holder)) {
                        int count = wordCounts.get(holder);
                        wordCounts.put(holder, count+1);
                    } else {
                        wordCounts.put(holder, 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        wordCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue())); //descending
        System.out.println(reverseSortedMap);
    }
}
