

package controller;

import model.*;

public class LoanController {
    private LoanContainer loanContainer;

    public LoanController(){
        loanContainer = LoanContainer.getInstance();
    }

    public void createLoan(int loanNumber, String borrowDate, Person person, LPCopy lpCopy){
        loanContainer.createLoan(new Loan(loanNumber, borrowDate, person, lpCopy));
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

}
