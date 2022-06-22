/*
Summary: Exercise 06_06 CreateLoan Class construction
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateLoans {
    public void CreateLoans() {
        Loan[] loanArray = new Loan[5];
        try {
            System.out.println("What's your Prime Interest Rate?");
            Scanner scanner = new Scanner(System.in);
            double userPrimeRate = scanner.nextDouble();

            for (int i = 0; i < loanArray.length; i++) {
                scanner.nextLine();
                double userLoanAmount = 0;
                System.out.println("What's your Lastname?");
                String userLastName = scanner.nextLine();
                do {
                    System.out.println("How much would you like to borrow?");
                    System.out.println("Maximum is: " + LoanConstants.MAXLOANAMOUNT);
                    userLoanAmount = scanner.nextDouble();
                } while (userLoanAmount > LoanConstants.MAXLOANAMOUNT);

                System.out.println("How long you wish to pay it off?");
                int userTerm = scanner.nextInt();
                if (userTerm == LoanConstants.MIDTERM) userTerm = LoanConstants.MIDTERM;
                else if (userTerm == LoanConstants.LONGTERM) userTerm = LoanConstants.LONGTERM;
                else userTerm = LoanConstants.SHORTTERM;
                int userLoanType = 0;
                do {
                    System.out.println("What type of Loan would you like to take?");
                    System.out.println("[1]. Personal  or  [2]. Buisness");
                    userLoanType = scanner.nextInt();
                    if (userLoanType == 1) {
                        loanArray[i] = new PersonalLoan(i + 1, userLastName, userLoanAmount, userTerm, userPrimeRate);
                    } else if (userLoanType == 2) {
                        loanArray[i] = new BusinessLoan(i + 1, userLastName, userLoanAmount, userTerm, userPrimeRate);
                    }
                } while (userLoanType != 1 && userLoanType != 2);
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
        } catch (Exception e) {
            System.out.println("Something Went wrong");
        }
        for (int i = 0; i < loanArray.length; i++) {
            System.out.println(loanArray[i]);
        }

    }


}
