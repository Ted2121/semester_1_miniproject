package TUI;

import controller.LPController;
import controller.LoanController;
import controller.PersonController;
import controller.ReturnController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReturnMenu {
    private LPController lpController;
    private LoanController loanController;
    private PersonController personController;
    private ReturnController returnController;

    public ReturnMenu() {
        lpController = new LPController();
        loanController = new LoanController();
        personController = new PersonController();
        returnController = new ReturnController();
    }

    public void start() {

        returnMenu();
    }

    private int writeReturnMenu() {
        System.out.println("****** Borrow menu ******");
        System.out.println(" (1) Return LP");
        System.out.println(" (2) Show current loans");
        System.out.println(" (0) Back");

        return new BorrowMenu().getIntegerFromUser();
    }

    private void returnMenu() {
        boolean running = true;
        while (running) {
            int choice = writeReturnMenu();
            switch (choice) {
                case 1 -> {
                    setLPCopySerialNumber();
                    returnController.closeLoan(returnController.findLoanBySerialNumber(MainMenu.getLpCopySerialNumberToChange()));

                }

                case 2 -> loanController.printLoans();
                case 0 -> running = false;
                default -> {System.err.println("Wrong input");
                    running = false;}

            }
            }
        }

    // this method sets the static field of MainMenu lpCopySerialNumberToChange to the user's input
    private void setLPCopySerialNumber(){
        int serialNum = 0;

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter LP Copy's serial number:");
            serialNum = scanner.nextInt();
            MainMenu.setLpCopySerialNumberToChange(serialNum);
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }

    }

}