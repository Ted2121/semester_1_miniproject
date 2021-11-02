package TUI;


import controller.LPController;

public class Run {
    MainMenu mainMenu;
    TryMe tryMe;

    public Run(){
        tryMe = new TryMe();
        mainMenu = new MainMenu();

    }
    public static void main(String[] args) {

    Run run = new Run();

    run.mainMenu.start();
    }
}
