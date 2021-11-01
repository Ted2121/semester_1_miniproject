

package controller;

import model.*;

public class LoanController {
    private LoanContainer loanContainer;

    public LoanController(){
        loanContainer = LoanContainer.getInstance();
    }

    public void createLoan(int loanNumber, String borrowDate){
        loanContainer.createLoan(new Loan(loanNumber, borrowDate));
    }

    // gets called after an LP is returned
    public void deleteLoan(Loan loan){
        deleteLoan(loan);
    }

}
