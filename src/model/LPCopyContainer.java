package model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class LPCopyContainer {

    private ArrayList<LPCopy> lpCopies;
    private static LPCopyContainer instance;

    private LPCopyContainer(){
        lpCopies = new ArrayList<LPCopy>();
    }

    // singleton
    public static LPCopyContainer getInstance(){
        if(instance==null)
            instance = new LPCopyContainer();
        return instance;
    }

    // part of CRUD
    public void deleteLPCopy(LPCopy lpCopy){
        lpCopies.remove(lpCopy);
    }

    public ArrayList<LPCopy> getLpCopies() {
        return lpCopies;
    }

    //TODO fix these
    // part of CRUD LPCopy
    public void addLPCopy(LPCopy lpCopy)
    {
        lpCopies.add(lpCopy);
    }

    // part of CRUD LPCopy
    public void updateLPCopyTitle(LPCopy lpCopy, String newTitle){
        lpCopy.setTitle(newTitle);
    }

    // part of CRUD LPCopy
    public void updateLPCopyBarcode(LPCopy lpCopy, int newBarcode){
        lpCopy.setBarcode(newBarcode);
    }

    // part of CRUD LPCopy
    public void updateLPCopyArtist(LPCopy lpCopy, String newArtist){
        lpCopy.setArtist(newArtist);
    }

    // part of CRUD LPCopy
    public void updateLPCopyPublicationDate(LPCopy lpCopy, String newPublicationDate){
        lpCopy.setPublicationDate(newPublicationDate);
    }



//    public void getInfo(){
//        // used lambda to print each LPCopy
//        lpCopies.forEach(lpCopy -> System.out.println(lpCopy));
//    }

    public void getInfo(){
        // used atomic number to be able to increment in lambda
        AtomicInteger i = new AtomicInteger(1);
        // used lambda to print each LP
        lpCopies.forEach(lpCopy -> {
            System.out.print("(" + i.getAndIncrement() + ") ");
            System.out.println(lpCopy);
        });

    }

    public LPCopy getFirstCopyAvail(ArrayList lpCopies, String title){

        LPCopy lpCopy = null;

        for (int i = 0; i < lpCopies.size(); i++){
            lpCopy = (LPCopy) lpCopies.get(i);
            if (lpCopy.getTitle().equals(title) && lpCopy.getState()){
        return lpCopy;
            }
        }
        return lpCopy;
    }

    public void updateLPCopyState(LPCopy lpCopy, boolean state){
        lpCopy.setState(state);
    }

    public void updateLPCopySerialNumber(LPCopy lpCopy, int serialNumber){
        lpCopy.setSerialNumber(serialNumber);
    }


    public LPCopy getLPCopyBySerialNumber(int serialNumber) {
        LPCopy lpCopy = null;
        boolean found = false;
        int i = 0;
        while (!found && i < lpCopies.size()) {
            if (lpCopies.get(i).getSerialNumber() == serialNumber) {
                System.out.println("Test" + lpCopies.get(i));
                lpCopy = lpCopies.get(i);
                found = true;
                return lpCopy;
            } else {
                i++;

            }

        }
        return lpCopy;
    }

    public int getLPCopySerialNumber(LPCopy lpCopy){
       return lpCopy.getSerialNumber();

    }
}
