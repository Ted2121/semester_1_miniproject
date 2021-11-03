package controller;

import model.Loan;
import model.LoanContainer;

public class ReturnController {
    private LoanContainer loanContainer;

    public ReturnController(){
        loanContainer = LoanContainer.getInstance();
    }

    public void createReturn(Loan loan){
        loanContainer.deleteLoan(loan);
    }
}
