package TUI;

import controller.LPController;
import controller.LoanController;
import controller.PersonController;
import model.LP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BorrowMenu {

    private LPController lpController;
    private LoanController loanController;
    private PersonController personController;

    public BorrowMenu(){
        lpController = new LPController();
        loanController = new LoanController();
        personController = new PersonController();
    }

    public void start() {
        new MainMenu().findingPersonMenu();
        loanMenu();
    }

    private void loanMenu() {
        int id = 1;
        boolean running = true;
        while (running) {
            int choice1 = writeLoanMenu();
            switch (choice1) {
                // TODO implement more menus
                case 1 -> {
                    int choice2 = lpCatalog();

                    // TODO replace placeholder date
                    // this method call sets the LPCopy of the loan to the first
                    // LPCopy available that matches the title of the LP that
                    // the user chose by inputting an integer for choice2

                    loanController.setLoanLPCopyAndPerson(loanController.createLoan(id, "PLACEHOLDER.DATE"),
                            lpController.getFirstCopyAvail(lpController.getLpCopyContainer().getLpCopies(),
                                    lpController.getLPTitleToString((LP) lpController.getLPs().get(choice2 - 1))),
                            personController.getPersonByName(MainMenu.getPersonName()));
                    System.out.println( "TEST" + lpController.getLPTitleToString((LP) lpController.getLPs().get(choice2 - 1)));
                    System.out.println(loanController.getInfo(loanController.getLoan()));
                    id++;

                }
                case 2 -> loanController.printLoans();
                case 0 -> running = false;
                default -> {System.err.println("Wrong input");
                            running = false;}

                // TODO test printLoans() method
            }
        }
    }



    private int writeLoanMenu() {

        System.out.println("****** Borrow menu ******");
        System.out.println(" (1) Create loan");
        System.out.println(" (2) Show current loans");
        System.out.println(" (0) Back");
        System.out.print("\n Choice:");
        return getIntegerFromUser();
    }

    public int lpCatalog(){
        System.out.println("****** LP Catalog ******");
        lpController.getInfo();
        return getIntegerFromUser();
    }

    private int getIntegerFromUser(){
        int choice = 0;
        try{
            Scanner scanner = new Scanner(System.in);
          choice = scanner.nextInt();
          return choice;
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
        return choice;
    }


}
