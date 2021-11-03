

package controller;

import model.*;

public class LoanController {
    private LoanContainer loanContainer;
    Loan loan;

    public LoanController(){
        loanContainer = LoanContainer.getInstance();
    }

    public void createLoan(int loanNumber, String borrowDate, Person person, LPCopy lpCopy){
        loanContainer.createLoan(new Loan(loanNumber, borrowDate, person, lpCopy));
    }

    public Loan createLoan(int id, String borrowDate){
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




    public void setLoanLPCopyAndPerson(Loan loan, LPCopy lpCopy, Person person){
        loan.setPerson(person);
        loan.setLpCopy(lpCopy);
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
