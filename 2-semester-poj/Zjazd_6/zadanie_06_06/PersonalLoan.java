/*
Summary: Exercise 06_06 PersonalLoan Class construction
         Extends Loan
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_06;

public class PersonalLoan extends Loan {
    public PersonalLoan(int loanID, String customerLastName, double loanAmount, int term, double primeInterestRate) {
        super(loanID, customerLastName, loanAmount, term);
        super.interestRate = primeInterestRate * 1.02;
    }
}
