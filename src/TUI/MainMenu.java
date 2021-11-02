package TUI;

import controller.LPController;
import controller.LoanController;
import controller.PersonController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private BorrowMenu borrowMenu;
    private LPController lpController;
    private LoanController loanController;
    private PersonController personController;

    public MainMenu() {
        borrowMenu = new BorrowMenu();
        lpController = new LPController();
        loanController = new LoanController();
        personController = new PersonController();
    }

    public void start() {
        mainMenu();
    }

    // TODO handle inputmismatch exception for all methods that use scanner
    private void mainMenu() {
        boolean running = true;
        while (running) {
            int choice = writeMainMenu();
            switch (choice) {
                case 1 -> borrowMenu.start();
                case 2 -> System.out.println(" Not implemented yet");
                case 3 -> borrowMenu.lpCatalog();
                case 9 -> System.out.println(" Not implemented yet");
                case 0 -> {
                    System.out.println(" Thank you and goodbye.");
                    running = false;
                }
                default -> System.out.println(" Unknown error occured, choice = " + choice);
            }
        }
    }

    // TODO make sure all branches are implemented
    private int writeMainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****** Main menu ******");
        System.out.println(" (1) Borrow menu");
        System.out.println(" (2) Return menu");
        System.out.println(" (3) LP Catalog");
        System.out.println(" (9) Generate testdata");// will generate testdata, delete in final version
        System.out.println(" (0) Quit the program");
        System.out.print("\n Choice:");

        while (!scanner.hasNextInt()) {
            System.out.println("Input must be a number - please try again");
            writeMainMenu();
        }
        int choice = scanner.nextInt();
        return choice;
    }

    private String inputPersonNameMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert name: ");
        String answer = scanner.next();
        return answer;
    }

    private int inputPersonPhoneNumberMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert phone number: ");
        int answer = scanner.nextInt();
        return answer;
    }

    private int writeFindingPersonMenu(){
        int choice = 0;
        try{Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Press: ");
        System.out.println(" (1) To find a person by name");
        System.out.println(" (2) To find a person by phone number");
        System.out.println(" (3) To go to the previous menu");

//        while (!scanner.hasNextInt()) {
//            System.out.println("Input must be a number - please try again");
//            writeFindingPersonMenu();
//        }

        choice = scanner.nextInt();
            return choice;
        } catch (InputMismatchException e){
            System.out.println("Invalid input");

        }
        return choice;
    }

    // This menu will be called for borrow menu and return menu
    // The catalog and CRUD can be accessed without entering a person
    public void findingPersonMenu() {
        boolean running = true;
        while (running) {
            int choice = writeFindingPersonMenu();

            switch (choice) {
                case 1 -> {personController.getPersonByName(inputPersonNameMenu());
                running = false;}
                case 2 -> personController.getPersonByPhoneNumber(inputPersonPhoneNumberMenu());
                case 3 -> {running = false;
                mainMenu();}
                default -> {
                    System.err.println("Invalid input");
                    findingPersonMenu();
                }
            }
        }
    }
}
