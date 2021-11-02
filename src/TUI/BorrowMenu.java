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
            int choice = writeLoanMenu();
            switch (choice) {
                // TODO implement more menus
                case 1 -> System.out.println();//lpcopyCatalog();
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
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }

    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input must be a number - please try again");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
}
