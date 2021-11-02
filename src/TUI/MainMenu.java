package TUI;

import java.util.Scanner;

public class MainMenu {
    private BorrowMenu borrowMenu;

    public MainMenu() {
        borrowMenu = new BorrowMenu();
    }

    public void start() {
        mainMenu();
    }

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
            scanner.nextLine();
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
}
