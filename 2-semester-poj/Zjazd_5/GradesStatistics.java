/*
Summary: Exercise 05_07 UML CHART Statistic Class construction
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_5;

import java.util.*;
import java.util.Scanner;

public class GradesStatistics {
    public void GradeStatistics() {
        Scanner scanner = new Scanner(System.in);
        int studendsNumber = 0;
        while (true) {
            try {
                System.out.println("Give number of students");
                studendsNumber = scanner.nextInt();
                if (studendsNumber == 0) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("There cannot be 0 students");
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }
        List<Integer> studentsGrades = new ArrayList<>(studendsNumber);

        for (int i = 1; i <= studendsNumber; ) {
            System.out.println("Enter the grade for student " + i);
            int temp = scanner.nextInt();
            if (temp > 0 && temp <= 100) {
                studentsGrades.add(temp);
                i++;
            } else {
                System.out.println("Grades are between 0 and 100, inclusive");
            }
        }
        System.out.println("The grades are :" + studentsGrades);
        System.out.print("The average is: ");
        System.out.format("%.2f%n", getAverage(studendsNumber, studentsGrades));
        System.out.print("The median is: ");
        System.out.format("%.2f%n", getMedian(studendsNumber, studentsGrades));
        System.out.println("The minimum is: " + getMinimum(studentsGrades));
        System.out.println("The maximum is: " + getMaximum(studentsGrades));
        System.out.print("The standard deviation is: ");
        System.out.format("%.2f%n", getStandardDeviation(studendsNumber, studentsGrades));
    }

    public double getAverage(int studendsNumber, List<Integer> studentsGrades) {
        int result = 0;
        for (Integer grades : studentsGrades) {
            result += grades;
        }
        return (double) result / studendsNumber;
    }

    public double getMedian(int studendsNumber, List<Integer> studentsGrades) {
        double index = studendsNumber % 2;
        Collections.sort(studentsGrades);
        if (index != 0) {
            return studentsGrades.get(studendsNumber / 2);
        } else {
            return (studentsGrades.get(studendsNumber / 2 - 1) + studentsGrades.get(studendsNumber / 2)) / 2;
        }
    }

    public int getMaximum(List<Integer> studentsGrades) {
        return Collections.max(studentsGrades);
    }

    public int getMinimum(List<Integer> studentsGrades) {
        return Collections.min(studentsGrades);
    }

    public double getStandardDeviation(int studendsNumber, List<Integer> studentsGrades) {
        double average = getAverage(studendsNumber, studentsGrades);
        double deviation = 0;
        for (int grades : studentsGrades) {
            double result = Math.pow(grades, 2) - Math.pow(average, 2);
            deviation += result;
        }
        return Math.sqrt(deviation / (studendsNumber));
    }
}
