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

    // part of CRUD LP
    public void addLPCopy(LPCopy lpCopy)
    {
        lpCopies.add(lpCopy);
    }

}
