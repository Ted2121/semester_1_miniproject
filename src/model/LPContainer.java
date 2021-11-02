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

    // part of CRUD LP
    public void addLP(LP lp){
        lps.add(lp);
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
}
