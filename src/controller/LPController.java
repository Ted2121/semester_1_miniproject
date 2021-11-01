package controller;

import model.*;

public class LPController {

    private LPCopyContainer lpCopyContainer;
    private LPContainer lpContainer;

    public LPController(){
        lpCopyContainer = LPCopyContainer.getInstance();
        lpContainer = LPContainer.getInstance();
    }

    public void addLPCopy(String title, String publicationDate, String artist, int barcode, int serialNumber, boolean state){
        lpCopyContainer.addLPCopy(new LPCopy(title, publicationDate, artist, barcode, serialNumber, state));
    }

    public void addLP(String title, String publicationDate, String artist, int barcode){
        lpContainer.addLP(new LP(title, publicationDate, artist, barcode));

    }

    // for populating the containers
    public void addLPCopy(LPCopy lpCopy) {
        lpContainer.addLP(lpCopy);
    }

    // for populating the containers
    public void addLP(LP lp) {
        lpContainer.addLP(lp);
    }

}
