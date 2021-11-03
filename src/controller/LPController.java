package controller;

import model.*;

import java.util.ArrayList;

public class LPController {

    private LPCopyContainer lpCopyContainer;
    private LPContainer lpContainer;

    public LPController(){
        lpCopyContainer = LPCopyContainer.getInstance();
        lpContainer = LPContainer.getInstance();
    }

    // adding a new LPCopy using closed architecture
    public void addLPCopy(String title, String publicationDate, String artist, int barcode, int serialNumber, boolean state){
        lpCopyContainer.addLPCopy(new LPCopy(title, publicationDate, artist, barcode, serialNumber, state));
    }

    // adding a new LP using closed architecture
    public void addLP(String title, String publicationDate, String artist, int barcode){
        lpContainer.addLP(new LP(title, publicationDate, artist, barcode));

    }

    public LPCopyContainer getLpCopyContainer() {
        return lpCopyContainer;
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
        lpCopyContainer.setCopyState(lpCopy, state);
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

    public String getLPTitleToString(LP lp){
        return lp.TitleToString();
    }
}
