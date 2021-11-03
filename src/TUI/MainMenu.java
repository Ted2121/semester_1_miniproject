package TUI;

import controller.LPController;
import controller.LoanController;
import controller.PersonController;
import model.Person;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private BorrowMenu borrowMenu;
    private LPController lpController;
    private LoanController loanController;
    private PersonController personController;
    private static String personName;
    private static int personNumber;
    private static String personNameToChange;
    private static int personPhoneNumberToChange;
    private static String lpTitleToChange;
    private static String lpCopySerialNumberToChange;

    public static String getPersonName() {
        return personName;
    }

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
                default -> System.out.println(" Unknown error occurred, choice = " + choice);
            }
        }
    }

    // TODO make sure all branches are implemented
    private int writeMainMenu() {
        int choice = 0;
       try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("****** Main menu ******");
            System.out.println(" (1) Borrow menu");
            System.out.println(" (2) Return menu");
            System.out.println(" (3) LP Catalog");
            // TODO delete person by name, phone number etc - can use find person by x methods
            System.out.println(" (4) Modify"); // will access the CRUD menu
            System.out.println(" (9) Generate testdata");
            System.out.println(" (0) Quit the program");
            System.out.print("\n Choice:");

            while (!scanner.hasNextInt()) {
                System.out.println("Input must be a number - please try again");
                writeMainMenu();
            }
            choice = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
        return choice;
    }

    // this menu starts when option 4 is selected in the main menu
    private int writeCrudMenu1(){

        int choice = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" (1) Modify persons");
            System.out.println(" (2) Modify LPs");
            System.out.println(" (3) Modify LP Copies");
            System.out.println(" (4) Back");
            choice = scanner.nextInt();
            return choice;
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
        return choice;
    }


    private void crudMenu1(){
        boolean running = true;
        int choice = writeCrudMenu1();
        while (running){
        switch (choice) {
            case 1 -> crudPersonMenu();
            case 2 -> crudLPMenu();
            case 3 -> crudLPCopyMenu();
            case 4 -> {
                running = false;
                mainMenu();
            }
        }
        }

    }

    private int writeCrudPersonMenu(){
        int choice = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" (1) Create person");
            System.out.println(" (2) View persons list");
            System.out.println(" (3) Change personal information");
            System.out.println(" (4) Delete person");
            System.out.println(" (5) Back");
            choice = scanner.nextInt();
            return choice;
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
        return choice;
    }

    // TODO finish the menu
    private void crudPersonMenu(){
        writeCrudPersonMenu();
        boolean running = true;
        int choice = writeCrudMenu1();
        while (running){
            switch (choice) {
                case 1 -> personController.createNewPersonText();
                case 2 -> personController.getInfo();
                case 3 ->
                case 4 -> {
                    running = false;
                    mainMenu();
                }
            }
        }

    }

    private int writeChangePersonalInformationMenu(){
       // findingPersonMenu();
    int choice = 0;

    try {
    Scanner scanner = new Scanner(System.in);

        System.out.println(" (1) Change name");
        System.out.println(" (2) Change address");
        System.out.println(" (3) Change postal code");
        System.out.println(" (4) Change city");
        System.out.println(" (5) Change phone number");
        System.out.println(" (6) Back");
        choice = scanner.nextInt();
    return choice;

    } catch (InputMismatchException e){
    System.out.println("Invalid input");
    }

    return choice;

    }

    private void changePersonalInformationMenu() {
        String newName = null;
        String newAddress = null;
        int newPostalCode = 0;
        String newCirt = null;
        int newPhoneNumber = 0;
        Scanner scanner = new Scanner(System.in);

        findingPersonMenu();
        Person personToModify = personController.getPersonByName(personNameToChange);
        int choice = writeChangePersonalInformationMenu();

        try {
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter new name:");
                    newName = scanner.next();
                    personToModify.setName(newName);
                }
                case 2 -> {
                    System.out.println("Enter new address:");
                    newAddress = scanner.next();
                    personToModify.setAddress(newAddress);
                }
                case 3 -> {
                    System.out.println("Enter new postal code:");
                    newPostalCode = scanner.nextInt();
                    personToModify.setPostalCode(newPostalCode);
                }
                case 4 -> {
                    System.out.println("Enter new postal code:");
                    newPostalCode = scanner.nextInt();
                    personToModify.setPostalCode(newPostalCode);
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }

        }



    private int writeCrudLPMenu(){

        int choice = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" (1) Create LP");
            System.out.println(" (2) View LPs");
            System.out.println(" (3) Change LP information");
            System.out.println(" (4) Delete LP");
            System.out.println(" (5) Back");
            choice = scanner.nextInt();
            return choice;
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
        return choice;
    }

    // TODO finish the menu
    private void crudLPMenu(){
        writeCrudLPMenu();
        boolean running = true;
        int choice = writeCrudMenu1();
        while (running){
            switch (choice) {
                case 1 -> System.out.println("placeholder");
                case 2 -> lpCatalogDisplay();
                case 4 -> {
                    running = false;
                    mainMenu();
                }
            }
        }

    }

    private int writeCrudLPCOpyMenu(){

        int choice = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" (1) Create LP Copy");
            System.out.println(" (2) View LP Copies");
            System.out.println(" (3) Change LP Copy information");
            System.out.println(" (4) Delete LP Copy");
            System.out.println(" (5) Back");
            choice = scanner.nextInt();
            return choice;
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
        return choice;
    }

    // TODO finish the menu
    private void crudLPCopyMenu(){
        writeCrudLPCOpyMenu();
        boolean running = true;
        int choice = writeCrudMenu1();
        while (running){
            switch (choice) {
                case 1 -> System.out.println("placeholder");
                case 2 -> lpCopyCatalogDisplay();
                case 4 -> {
                    running = false;
                    mainMenu();
                }
            }
        }

    }

    // this method only displays the catalog - different from the one in borrow menu that also takes user input
    public void lpCatalogDisplay(){
        System.out.println("****** LP Catalog ******");
        lpController.getLPInfo();
    }

    // this method only displays the catalog - different from the one in borrow menu that also takes user input
    public void lpCopyCatalogDisplay(){
        System.out.println("****** LP Copy Catalog ******");
        lpController.getLPCopyInfo();

    }

    private String inputPersonNameMenu(){
        String answer = null;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please insert name: ");

            answer = scanner.next();
            personName = answer;
            personNameToChange = answer;
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
        return answer;
    }

//    public String getNameFromInput(){
//        String name = inputPersonNameMenu();
//        return name;
//    }

    private int inputPersonPhoneNumberMenu(){
        int answer = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please insert phone number: ");
            answer = scanner.nextInt();
            personNumber = answer;
            personPhoneNumberToChange = answer;
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
        return answer;
    }

    private int writeFindingPersonMenu(){
        int choice = 0;
        try{
        Scanner scanner = new Scanner(System.in);
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
