package model;

import java.util.ArrayList;

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

    public ArrayList<LPCopy> getLpCopies() {
        return lpCopies;
    }

    // part of CRUD LP
    public void addLPCopy(LPCopy lpCopy)
    {
        lpCopies.add(lpCopy);
    }

    public void getInfo(){
        // used lambda to print each LPCopy
        lpCopies.forEach(lpCopy -> System.out.println(lpCopy));
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

    public void setCopyState(LPCopy lpCopy, boolean state){
        lpCopy.setState(state);
    }
}
