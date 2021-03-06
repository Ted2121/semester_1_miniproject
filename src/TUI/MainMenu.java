package TUI;

import controller.LPController;
import controller.LoanController;
import controller.PersonController;


import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private BorrowMenu borrowMenu;
    private ReturnMenu returnMenu;
    private LPController lpController;

    private PersonController personController;
    private static String personName;
    private static int personNumber;
    private static String personNameToChange;
    private static int personPhoneNumberToChange;
    private static String lpTitleToChange;
    private static int lpCopySerialNumberToChange;

    public static String getPersonName() {
        return personName;
    }

    public MainMenu() {
        borrowMenu = new BorrowMenu();
        returnMenu = new ReturnMenu();
        lpController = new LPController();
        personController = new PersonController();
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
                case 2 -> returnMenu.start();
                case 3 -> {borrowMenu.lpCatalog();
                        mainMenu();}
                case 4 -> crudMenu1();
                case 0 -> {
                    System.out.println(" Thank you and goodbye.");
                    running = false;
                }
                default -> System.out.println("Invalid input: " + choice);
            }
        }
    }

    private int writeMainMenu() {
        int choice = 0;
       try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("****** Main menu ******");
            System.out.println(" (1) Borrow menu");
            System.out.println(" (2) Return menu");
            System.out.println(" (3) LP Catalog");
            System.out.println(" (4) Modify"); // will access the CRUD menu
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

    // crud person is working as intended
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

    private void crudPersonMenu(){

        int choice = writeCrudPersonMenu();

            switch (choice) {
                case 1 -> personController.createNewPersonText();
                case 2 -> personController.getInfo();
                case 3 -> changePersonalInformationMenu();
                case 4 -> {findingPersonMenu();
                    personController.deletePerson(personController.getPersonByName(personName));}
                default -> mainMenu();

            }


    }

    private int writeChangePersonalInformationMenu(){

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
        String newCity = null;
        int newPhoneNumber = 0;
        Scanner scanner = new Scanner(System.in);

        findingPersonMenu();
        personController.setPerson(personController.getPersonByName(personNameToChange));
        int choice = writeChangePersonalInformationMenu();

        try {
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter new name:");
                    newName = scanner.nextLine();
                    personController.updatePersonName(personController.getPerson(), newName);
                }
                case 2 -> {
                    System.out.println("Enter new address:");
                    newAddress = scanner.nextLine();
                    personController.updatePersonAddress(personController.getPerson(), newAddress);
                }
                case 3 -> {
                    System.out.println("Enter new postal code:");
                    newPostalCode = scanner.nextInt();
                    personController.updatePersonPostalCode(personController.getPerson(), newPostalCode);
                }
                case 4 -> {
                    System.out.println("Enter new city:");
                    newCity = scanner.nextLine();
                    personController.updatePersonCity(personController.getPerson(), newCity);
                }
                case 5 -> {
                    System.out.println("Enter new phone number:");
                    newPhoneNumber = scanner.nextInt();
                    personController.updatePersonPhoneNumber(personController.getPerson(), newPhoneNumber);
                }
                case 6 -> crudPersonMenu();
                default -> System.exit(0);
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

    private void crudLPMenu(){

        int choice = writeCrudLPMenu();

            switch (choice) {
                case 1 -> lpController.createNewLPMenu();
                case 2 -> lpCatalogDisplay();
                case 3 -> changeLPInformationMenu();
                case 4 -> deleteLPMenu();
                default ->{
                    System.out.println("Invalid input");
                    mainMenu();
                }
                }

            }

    private void deleteLPMenu(){
        findingLPMenu();
        lpController.deleteLP(lpController.getLPByTitle(lpTitleToChange));
    }

    private void changeLPInformationMenu(){
        String newTitle = null;
        String newArtist = null;
        int newBarcode = 0;
        String newPublicationDate = null;


        findingLPMenu();
        lpController.setLp(lpController.getLPByTitle(lpTitleToChange));

        int choice = writeChangeLPInformationMenu();

        try {
            Scanner scanner = new Scanner(System.in);
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter new title:");
                    newTitle = scanner.nextLine();
                    lpController.updateLPTitle(lpController.getLp(), newTitle);
                }
                case 2 -> {
                    System.out.println("Enter new artist:");
                    newArtist = scanner.nextLine();
                    lpController.updateLPArtist(lpController.getLp(), newArtist);
                }
                case 3 -> {
                    System.out.println("Enter new publication date:");
                    newPublicationDate = scanner.nextLine();
                    lpController.updateLPPublicationDate(lpController.getLp(), newPublicationDate);
                }
                case 4 -> {
                    System.out.println("Enter new barcode:");
                    newBarcode = scanner.nextInt();
                    lpController.updateLPBarcode(lpController.getLp(), newBarcode);
                }
                case 5 -> crudLPMenu();
                default -> System.exit(0);
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
    }

    private int writeChangeLPInformationMenu(){
        int choice = 0;

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println(" (1) Change title");
            System.out.println(" (2) Change artist");
            System.out.println(" (3) Change publication date");
            System.out.println(" (4) Change barcode");
            System.out.println(" (5) Back");
            choice = scanner.nextInt();
            return choice;

        } catch (InputMismatchException e){
            System.out.println("Invalid input");
        }

        return choice;
    }

    private void findingLPMenu() {

        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter LP's title:");
            lpTitleToChange = scanner.nextLine();
//            System.out.println("TESTING " + lpTitleToChange);
        } catch (InputMismatchException e){
            System.out.println("Invalid input");
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

    private void crudLPCopyMenu(){

        int choice = writeCrudLPCOpyMenu();

            switch (choice) {
                case 1 -> lpController.createNewLPCopyMenu();
                case 2 -> lpCopyCatalogDisplay();
                case 3 -> changeLPCopyInformation();
                case 4 -> deleteLPCopyMenu();
                default ->{
                    System.out.println("Invalid input");
                    mainMenu();
                }
            }

    }

    private void deleteLPCopyMenu() {
        findingLPCopyMenu();
        lpController.deleteLPCopy(lpController.getLPCopyBySerialNumber(lpCopySerialNumberToChange));
    }

    private void changeLPCopyInformation(){
        String newTitle = null;
        String newArtist = null;
        int newBarcode = 0;
        String newPublicationDate = null;
        int newSerialNumber = 0;
        boolean newState = false;

        findingLPCopyMenu();
        lpController.setLpCopy(lpController.getLPCopyBySerialNumber(lpCopySerialNumberToChange));

        int choice = writeChangeLPCopyInformationMenu();

        try {
            Scanner scanner = new Scanner(System.in);
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter new title:");
                    newTitle = scanner.nextLine();
                    lpController.updateLPCopyTitle(lpController.getLpCopy(), newTitle);
                }
                case 2 -> {
                    System.out.println("Enter new artist:");
                    newArtist = scanner.nextLine();
                    lpController.updateLPCopyArtist(lpController.getLpCopy(), newArtist);
                }
                case 3 -> {
                    System.out.println("Enter new publication date:");
                    newPublicationDate = scanner.nextLine();
                    lpController.updateLPCopyPublicationDate(lpController.getLpCopy(), newPublicationDate);
                }
                case 4 -> {
                    System.out.println("Enter new barcode:");
                    newBarcode = scanner.nextInt();
                    lpController.updateLPCopyBarcode(lpController.getLpCopy(), newBarcode);
                }
                case 5 -> {
                    System.out.println("Enter new serial number:");
                    newSerialNumber = scanner.nextInt();
                    lpController.updateLPCopySerialNumber(lpController.getLpCopy(), newSerialNumber);
                }
                case 6 -> {
                    System.out.println("Enter new state:");
                    newState = scanner.nextBoolean();
                    lpController.updateLPCopyState(lpController.getLpCopy(), newState);
                }

                case 7 -> crudLPCopyMenu();
                default -> System.exit(0);
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
    }

    private int writeChangeLPCopyInformationMenu() {
        int choice = 0;

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println(" (1) Change title");
            System.out.println(" (2) Change artist");
            System.out.println(" (3) Change publication date");
            System.out.println(" (4) Change barcode");
            System.out.println(" (5) Change serial number");
            System.out.println(" (6) Change state");
            System.out.println(" (7) Back");
            choice = scanner.nextInt();
            return choice;

        } catch (InputMismatchException e){
            System.out.println("Invalid input");
        }

        return choice;
    }

    private void findingLPCopyMenu(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter LP Copy's serial number:");
            lpCopySerialNumberToChange = scanner.nextInt();
          System.out.println("TESTING " + lpCopySerialNumberToChange);

        } catch (InputMismatchException e){
            System.out.println("Invalid input");
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

            answer = scanner.nextLine();
            personName = answer;
            personNameToChange = answer;
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
        return answer;
    }

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
                case 2 -> {personController.getPersonByPhoneNumber(inputPersonPhoneNumberMenu());
                    running = false;}
                case 3 -> {running = false;
                mainMenu();}
                default -> {
                    System.err.println("Invalid input");
                    findingPersonMenu();
                }
            }
        }
    }

    public static int getLpCopySerialNumberToChange() {
        return lpCopySerialNumberToChange;
    }

    public static void setLpCopySerialNumberToChange(int lpCopySerialNumberToChange) {
        MainMenu.lpCopySerialNumberToChange = lpCopySerialNumberToChange;
    }
}
