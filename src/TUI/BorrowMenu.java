package TUI;

import controller.LPController;
import controller.LoanController;
import controller.PersonController;

import java.time.LocalDate;
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

                case 1 -> {
                    int choice2 = lpCatalog();

                    // this method call sets the LPCopy of the loan to the first
                    // LPCopy available that matches the title of the LP that
                    // the user chose by inputting an integer for choice2
                    loanController.setLoanLPCopyAndPerson(loanController.createLoan(id, LocalDate.now()),
                            lpController.getFirstCopyAvail(lpController.getLpCopyContainer().getLpCopies(),
                                    lpController.getLPTitleToString((model.LP) lpController.getLPs().get(choice2 - 1))),
                            personController.getPersonByName(MainMenu.getPersonName()));
                    System.out.println( "TEST HERE " + lpController.getLPTitleToString((model.LP) lpController.getLPs().get(choice2 - 1)));


                    System.out.println(loanController.getInfo(loanController.getLoan()));
                    loanController.getLoan().getLpCopy().setState(false);
                    id++;

                }
                case 2 -> loanController.printLoans();
                case 0 -> running = false;
                default -> {System.err.println("Wrong input");
                            running = false;}

            }
        }
    }

    private int writeLoanMenu() {

        System.out.println("****** Borrow menu ******");
        System.out.println(" (1) Create loan");
        System.out.println(" (2) Show current loans");
        System.out.println(" (0) Back");

        return getIntegerFromUser();
    }

    public int lpCatalog(){
        System.out.println("****** LP Catalog ******");
        lpController.getLPInfo();
        return getIntegerFromUser();
    }

    public int getIntegerFromUser(){
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
