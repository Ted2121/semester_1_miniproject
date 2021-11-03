package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class LoanContainer {

    private ArrayList<Loan> loans;
    private static LoanContainer instance;

    private LoanContainer(){
        loans = new ArrayList<Loan>();
    }

    // singleton
    public static LoanContainer getInstance(){
        if(instance==null)
            instance = new LoanContainer();
        return instance;
    }

    public void setBorrowDate(Loan loan, LocalDate localDate){
        loan.setBorrowDate(localDate);
    }

    // part of Loan use case - gets called whenever there is a new loan request
    public void createLoan(Loan loan)
    {
        loans.add(loan);
    }

    public void deleteLoan(Loan loan){
        loans.remove(loan);
    }

    public void printLoans(){
        // used lambda to print Loans
        loans.forEach(loan -> System.out.println(loan));
    }

}
