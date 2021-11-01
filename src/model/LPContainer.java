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
       // System.out.println(lps);

    }

    public void toString(LP lp){

    }

    public void getInfo(ArrayList lps){

lps.forEach(lp -> System.out.println(lp));

    }

    public ArrayList<LP> getLps() {
        return lps;
    }
}
