

package controller;

import model.*;

import java.time.LocalDate;

public class LoanController {
    private LoanContainer loanContainer;

    Loan loan;

    public LoanController(){
        loanContainer = LoanContainer.getInstance();
    }

    public Loan createLoan(int id, LocalDate borrowDate){
        this.loan = new Loan(id, borrowDate);
        loan.setId(id);
        loanContainer.createLoan(loan);
      return loan;
    }

    // this is where you can change the loan period - replace the 14
    public void setLoanLPCopyAndPerson(Loan loan, LPCopy lpCopy, Person person){
        loan.setPerson(person);
        loan.setLpCopy(lpCopy);
        loanContainer.setReturnDate(loan, loanContainer.getBorrowDate(loan).plusDays(14));
    }

    public String getInfo(Loan loan){
        return loan.toString();
    }

    public Loan getLoan() {
        return loan;
    }

    public void printLoans(){
        loanContainer.printLoans();
    }

}
