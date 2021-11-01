package model;

import java.util.ArrayList;

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

    // part of CRUD LP
    public void addLP(LP lp)
    {
        lps.add(lp);
    }

    public void getInfo(ArrayList lps){
//     lps.forEach(lp -> System.out.println("Title: " + lps.get());
        int i= 0;
        while(i<lps.size()){
            if(lps.get(i))

                i++;
        }
    }
}
