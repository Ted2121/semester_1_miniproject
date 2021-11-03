package TUI;

import controller.LPController;
import controller.LoanController;
import controller.PersonController;

public class ReturnMenu {
    private LPController lpController;
    private LoanController loanController;
    private PersonController personController;

    public ReturnMenu(){
        lpController = new LPController();
        loanController = new LoanController();
        personController = new PersonController();
    }


    public void start() {
        new MainMenu().findingPersonMenu();
        returnMenu();
    }



}
