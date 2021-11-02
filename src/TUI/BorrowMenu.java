package TUI;

import controller.LPController;

import java.util.Scanner;

public class BorrowMenu {

    private LPController lpController;

    public BorrowMenu(){
        lpController = new LPController();
    }

    public void start() {
        loanMenu();
    }

    private void loanMenu() {
        boolean running = true;
        while (running) {
            int choice1 = writeLoanMenu();
            switch (choice1) {
                // TODO implement more menus
                case 1 -> {
                    int choice2 = lpCatalog();
                    switch (choice2){
                        case 1 -> {

                        }
                    }
                }
                case 0 -> running = false;
                default -> {System.err.println("Wrong input");
                            running = false;}

            }
        }
    }

    private int writeLoanMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Loan menu ******");
        System.out.println(" (1) Create loan");
        System.out.println(" (0) Back");
        System.out.print("\n Choice:");
        int choice2 = getIntegerFromUser(keyboard);
        return choice2;
    }

    private int lpCatalog(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("****** LP Catalog ******");
        lpController.getInfo();
        int choice1 = getIntegerFromUser(scanner);
        return choice1;
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
