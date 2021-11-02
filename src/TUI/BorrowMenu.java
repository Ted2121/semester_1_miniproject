package TUI;

import controller.LPController;
import controller.LoanController;
import model.LP;

import java.util.Scanner;

public class BorrowMenu {

    private LPController lpController;
    private LoanController loanController;

    public BorrowMenu(){
        lpController = new LPController();
        loanController = new LoanController();
    }

    public void start() {
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
                    loanController.setLoanLPCopy(loanController.createLoan(id, "PLACEHOLDER.DATE"),
                            lpController.getFirstCopyAvail(lpController.getLpCopyContainer().getLpCopies(),
                                    lpController.getLPTitleToString((LP) lpController.getLPs().get(choice2 - 1))));
                    System.out.println( "TEST" + lpController.getLPTitleToString((LP) lpController.getLPs().get(choice2 - 1)));
                    System.out.println(loanController.getInfo(loanController.getLoan()));
                    id++;

                }
                case 0 -> running = false;
                default -> {System.err.println("Wrong input");
                            running = false;}

                // TODO test printLoans() method
            }
        }
    }

    private int writeLoanMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****** Loan menu ******");
        System.out.println(" (1) Create loan");
        System.out.println(" (0) Back");
        System.out.print("\n Choice:");
        return getIntegerFromUser(scanner);
    }

    public int lpCatalog(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("****** LP Catalog ******");
        lpController.getInfo();
        return getIntegerFromUser(scanner);
    }

    private int getIntegerFromUser(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Input must be a number - please try again");
            // recursive call for trying again
           getIntegerFromUser(scanner);
        }
        return scanner.nextInt();
    }
}
