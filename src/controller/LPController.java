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
    public void getInfo(){
        lpContainer.getInfo();
    }

    public LPCopy getFirstCopyAvail(ArrayList lpCopies){
       LPCopy copy =  lpCopyContainer.getFirstCopyAvail(lpCopies);
       return copy;
    }

}
