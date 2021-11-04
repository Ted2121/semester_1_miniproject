package TUI;

import controller.LPController;
import controller.LoanController;
import controller.PersonController;
import controller.ReturnController;

public class ReturnMenu {
    private LPController lpController;
    private LoanController loanController;
    private PersonController personController;
    private ReturnController returnController;

    public ReturnMenu(){
        lpController = new LPController();
        loanController = new LoanController();
        personController = new PersonController();
        returnController = new ReturnController();
    }


    public void start() {
        new MainMenu().findingPersonMenu();
//        returnMenu();
    }



}
