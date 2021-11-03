package model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class LPContainer {

    private ArrayList<LP> lps;
    private static LPContainer instance;

    private LPContainer(){
        lps = new ArrayList<LP>();
    }

    // singleton
    public static LPContainer getInstance(){
        if(instance==null)
            instance = new LPContainer();
        return instance;
    }

    // part of CRUD
    public void deleteLP(LP lp){
        lps.remove(lp);
    }

    // part of CRUD LP
    public void addLP(LP lp){
        lps.add(lp);
    }

    // part of CRUD LP
    public void updateLPTitle(LP lp, String newTitle){
        lp.setTitle(newTitle);
    }

    // part of CRUD LP
    public void updateLPBarcode(LP lp, int newBarcode){
        lp.setBarcode(newBarcode);
    }

    // part of CRUD LP
    public void updateLPArtist(LP lp, String newArtist){
        lp.setArtist(newArtist);
    }

    // part of CRUD LP
    public void updateLPPublicationDate(LP lp, String newPublicationDate){
        lp.setPublicationDate(newPublicationDate);
    }

    public void getInfo(){
        // used atomic number to be able to increment in lambda - for lpCatalog method in model.borrowMenu
        AtomicInteger i = new AtomicInteger(1);
        // used lambda to print each LP
        lps.forEach(lp -> {
            System.out.print("(" + i.getAndIncrement() + ") ");
            System.out.println(lp);
                            });

    }

    public ArrayList<LP> getLps() {
        return lps;
    }

    public LP getLPByTitle(String title) {
        boolean found = false;
        int i = 0;
        while(!found && i<lps.size()){
            if(lps.get(i).getTitle().equals(title))
                found = true;
            else
                i++;
        }
        if(found)

            return lps.get(i);
        else{
            System.out.println("Test " + lps.get(i));
            return null;}
    }
}
