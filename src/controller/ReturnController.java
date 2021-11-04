package controller;

import model.Loan;
import model.LoanContainer;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReturnController {
    private LoanContainer loanContainer;
    private LoanController loanController;
    // not to be confused with Loan.returnDate
    // this one is the date the person actually returns the LP
    private LocalDate dateOfReturn;
    ArrayList<Loan> loans;

    public ReturnController(){
        loanContainer = LoanContainer.getInstance();
        this.dateOfReturn = LocalDate.now();
        loans = loanContainer.getLoans();
    }

    public void closeLoan(Loan loan){
        loanContainer.deleteLoan(loan);
        System.out.println("LP return on: " + dateOfReturn);
    }

    // this method finds and returns a Loan by the serial number of the LPCopy attached to it
    public Loan findLoanBySerialNumber(int serialNumber){
        Loan loanToReturn = null;
        boolean found = false;
        int i = 0;
        while (!found && i < loans.size()) {
            if (loans.get(i).getLpCopy().getSerialNumber() == serialNumber) {
                //System.out.println("Test" + loans.get(i));
                loanToReturn = loans.get(i);
                found = true;
                return loanToReturn;
            } else {
                i++;

            }

        }
        //if (loanToReturn == null) System.out.println("Loan doesn't exist");
        return loanToReturn;
    }

//    // this method finds and returns a Loan by the serial number of the LPCopy attached to it
//    public Loan findLoanBySerialNumber(int serialNumber){
//        Loan loanToReturn = null;
//        boolean found = false;
//        int i = 0;
//        while (!found && i < loans.size()) {
//            if (loans.get(i).getLpCopy().getSerialNumber() == serialNumber) {
//                System.out.println("Test" + loans.get(i));
//                loanToReturn = loans.get(i);
//                found = true;
//                return loanToReturn;
//            } else {
//                i++;
//
//            }
//
//        }
//        return loanToReturn;
//    }
}
