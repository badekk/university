/*
Summary: Exercise 06_06 Loan AbstractClass construction
        Implements LoanConstants
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_6.zadanie_06_06;

public abstract class Loan implements LoanConstants {
    private int loanID;
    private String customerLastName;
    private double loanAmount;
    protected double interestRate;
    private int term;

    public Loan(int loanID, String customerLastName, double loanAmount, int term) {
        this.loanID = loanID;
        this.customerLastName = customerLastName;
        this.loanAmount = loanAmount;
        this.term = term;
    }

    @Override
    public String toString() {
        double amountOwed = (this.loanAmount + (this.loanAmount * (this.interestRate/100) * term)) ;
        return "[loanID]= " + loanID +
                     ", [CustomerLastName]= " + customerLastName +
                     ", [LoanAmount]= " + loanAmount +
                     ", [InterestRate]= " + String.format("%.2f",interestRate) +
                     ", [AmountOwed}= " + String.format("%.2f",amountOwed) +
                     ", [Term]= " + term + " years ]";
    }
}
