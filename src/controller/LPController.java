package controller;

import model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LPController {

    private LPCopyContainer lpCopyContainer;
    private LPContainer lpContainer;
    private PersonContainer personContainer;
    private LP lp;
    LPCopy lpCopy;

    public LPController(){
        lpCopyContainer = LPCopyContainer.getInstance();
        lpContainer = LPContainer.getInstance();
        personContainer = PersonContainer.getInstance();
    }

    // adding a new LPCopy using closed architecture
    public void addLPCopy(String title, String publicationDate, String artist, int barcode, int serialNumber, boolean state){
        lpCopyContainer.addLPCopy(new LPCopy(title, publicationDate, artist, barcode, serialNumber, state));
    }

//     adding a new LP using closed architecture
    public void addLP(String title, String publicationDate, String artist, int barcode){
        lpContainer.addLP(new LP(title, publicationDate, artist, barcode));

    }

    public LP addAndReturnLP(String title, String publicationDate, String artist, int barcode){
        lp = new LP(title, publicationDate, artist, barcode);
        lpContainer.addLP(lp);
        return lp;
    }

    public LPCopyContainer getLpCopyContainer() {
        return lpCopyContainer;
    }

    public LP getLPByTitle(String title){
        LP lp = lpContainer.getLPByTitle(title);
        if(lp == null){
            System.err.println("LP not in the database");
            System.out.println("Would you like to add a new LP?");
            Scanner scanner = new Scanner(System.in);
            String answer1 = scanner.next();
            switch (answer1){
                case "yes", "Yes" -> {
                    lp = createNewLPMenu();
                    return lp;
                }
                default -> {

                    String answer2 = tryAgain();
                    switch (answer2){
                        case "yes", "Yes" -> getLPByTitle(title);
                        default -> System.exit(0);
                    }
                }
            }
        }
        return lp;
    }

    public LPCopy getLPCopyBySerialNumber(int serialNumber){
        LPCopy lpCopy = lpCopyContainer.getLPCopyBySerialNumber(serialNumber);
        if(lp == null){
            System.err.println("LP Copy not in the database");
            System.out.println("Would you like to add a new LP Copy?");
            Scanner scanner = new Scanner(System.in);
            String answer1 = scanner.next();
            switch (answer1){
                case "yes", "Yes" -> {
                    lp = createNewLPMenu();
                    return lpCopy;
                }
                default -> {

                    String answer2 = tryAgain();
                    switch (answer2){
                        case "yes", "Yes" -> getLPCopyBySerialNumber(serialNumber);
                        default -> System.exit(0);
                    }
                }
            }
        }
        return lpCopy;
    }

    public LP getLp() {
        return lp;
    }

    public void setLp(LP lp) {
        this.lp = lp;
    }

    public String tryAgain(){
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        return answer;
    }
    // TODO garbage?
    // for populating the containers
//    public void addLPCopy(LPCopy lpCopy) {
//        lpContainer.addLP(lpCopy);
//    }


    // TODO garbage?
    // for populating the containers
//    public void addLP(LP lp) {
//        lpContainer.addLP(lp);
//    }

    // getting info using closed architecture
    public void getLPInfo(){
        lpContainer.getInfo();
    }

    public void getLPCopyInfo(){
        lpCopyContainer.getInfo();
    }

    // accessing getFirstCopyAvail of model.LPCopyContainer
    public LPCopy getFirstCopyAvail(ArrayList lpCopies, String title){
       LPCopy copy =  lpCopyContainer.getFirstCopyAvail(lpCopies, title);
       return copy;
    }

    // accessing setState method of model.LPCopy through model.LPContainer - keeping a closed architecture
    public void setLpCopyState(LPCopy lpCopy, boolean state){
        lpCopyContainer.updateLPCopyState(lpCopy, state);
    }

    public ArrayList getLPs(){
        ArrayList LPs = lpContainer.getLps();
        return LPs;
    }

    // part of CRUD LP
    public void updateLPTitle(LP lp, String title){
        lpContainer.updateLPTitle(lp, title);
    }

    // part of CRUD LP
    public void updateLPBarcode(LP lp, int newBarcode){
        lpContainer.updateLPBarcode(lp, newBarcode);
    }

    // part of CRUD LP
    public void updateLPArtist(LP lp, String newArtist){
        lpContainer.updateLPArtist(lp, newArtist);
    }

    // part of CRUD LP
    public void updateLPPublicationDate(LP lp, String newPublicationDate){
        lpContainer.updateLPPublicationDate(lp, newPublicationDate);
    }

    // part of CRUD LP
    public void deleteLP(LP lp){
        lpContainer.deleteLP(lp);
    }

    // part of CRUD LPCopy
    public void updateLPCopyTitle(LPCopy lpCopy, String newTitle){
        lpCopyContainer.updateLPCopyTitle(lpCopy, newTitle);
    }

    // part of CRUD LPCopy
    public void updateLPCopyBarcode(LPCopy lpCopy, int newBarcode){
        lpCopyContainer.updateLPCopyBarcode(lpCopy, newBarcode);
    }

    // part of CRUD LPCopy
    public void updateLPCopyArtist(LPCopy lpCopy, String newArtist){
        lpCopyContainer.updateLPCopyArtist(lpCopy, newArtist);
    }

    // part of CRUD LPCopy
    public void updateLPCopyPublicationDate(LPCopy lpCopy, String newPublicationDate){
        lpCopyContainer.updateLPCopyPublicationDate(lpCopy, newPublicationDate);
    }

    // part of CRUD LPCopy
    public void deleteLPCopy(LPCopy lpCopy){
        lpCopyContainer.deleteLPCopy(lpCopy);
    }

    // part of CRUD LPCopy
    public void updateLPCopyState(LPCopy lpCopy, boolean state){
        lpCopyContainer.updateLPCopyState(lpCopy, state);
    }

    // part of CRUD LPCopy
    public void updateLPCopySerialNumber(LPCopy lpCopy, int serialNumber){
        lpCopyContainer.updateLPCopySerialNumber(lpCopy, serialNumber);
    }

    public String getLPTitleToString(LP lp){
        return lp.TitleToString();
    }

    public LP createNewLPMenu(){
       String title = null;
       String publicationDate = null;
       String artist = null;
       int barcode = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter LP's title:");
            title = scanner.next();
            System.out.println("Enter LP's publication date:");
            publicationDate = scanner.next();
            System.out.println("Enter LP's artist:");
            artist = scanner.next();
            System.out.println("Enter LP's barcode:");
            barcode = scanner.nextInt();


            lp = new LP(title, publicationDate, artist, barcode);
            lpContainer.addLP(lp);
        }catch (InputMismatchException e){
            System.out.println("Invalid Input");
        }
        return lp;
    }

    public LPCopy getLpCopy() {
        return lpCopy;
    }

    public void setLpCopy(LPCopy lpCopy) {
        this.lpCopy = lpCopy;
    }

    public LPCopy createNewLPCopyMenu(){
        String title = null;
        String publicationDate = null;
        String artist = null;
        int barcode = 0;
        int serialNumber = 0;
        boolean state = false;

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter LP's title:");
            title = scanner.next();
            System.out.println("Enter LP's publication date:");
            publicationDate = scanner.next();
            System.out.println("Enter LP's artist:");
            artist = scanner.next();
            System.out.println("Enter LP's barcode:");
            barcode = scanner.nextInt();
            System.out.println("Enter LP's serial number:");
            serialNumber = scanner.nextInt();
            System.out.println("Enter LP's state:");
            state = scanner.nextBoolean();

            lpCopy = new LPCopy(title, publicationDate, artist, barcode, serialNumber, state);
            lpCopyContainer.addLPCopy(lpCopy);
        }catch (InputMismatchException e){
            System.out.println("Invalid Input");
        }
        return lpCopy;
    }

    public int getLPCopySerialNumber(){
       return lpCopyContainer.getLPCopySerialNumber(lpCopy);
    }
}
