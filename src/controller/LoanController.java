

package controller;

import model.*;

import java.time.LocalDate;

public class LoanController {
    private LoanContainer loanContainer;

    Loan loan;

    public LoanController(){
        loanContainer = LoanContainer.getInstance();
    }

    public void createLoan(int loanNumber, LocalDate borrowDate, Person person, LPCopy lpCopy){
        loanContainer.createLoan(new Loan(loanNumber, borrowDate, person, lpCopy));
    }

    public Loan createLoan(int id, LocalDate borrowDate){
        this.loan = new Loan(id, borrowDate);
        loan.setId(id);
        loanContainer.createLoan(loan);
      return loan;
    }

    // gets called after an LP is returned
    public void deleteLoan(Loan loan){
        loanContainer.deleteLoan(loan);
    }

    // TODO garbage?
    // for populating the containers
//    public void createLoan(Loan loan) {
//        loanContainer.createLoan(loan);
//    }

    public void setLoanLPCopy(Loan loan, LPCopy lpCopy){
        loan.setLpCopy(lpCopy);
    }

    public void setLoanPerson(Loan loan, Person person){
        loan.setPerson(person);
    }

    //testing something

    public void setBorrowDate(Loan loan){
        loanContainer.setBorrowDate(loan, LocalDate.now());
    }


    public LocalDate getBorrowDate(Loan loan){
       LocalDate localDate =  loanContainer.getBorrowDate(loan);
       return localDate;
    }

    public void setLoanLPCopyAndPerson(Loan loan, LPCopy lpCopy, Person person){
        loan.setPerson(person);
        loan.setLpCopy(lpCopy);
        loanContainer.setReturnDate(loan, loanContainer.getBorrowDate(loan).plusDays(14));
    }

//    public void setReturnDate(Loan loan){
//        loanContainer.setReturnDate(loan, loanContainer.getBorrowDate(loan).plusDays(14));
//    }

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
