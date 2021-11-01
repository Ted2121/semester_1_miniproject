package TUI;


import controller.LPController;

public class Run {
    MainMenu mainMenu;

    public Run(){
        mainMenu = new MainMenu();
    }
    public static void main(String[] args) {
        LPController lpController = new LPController();
        lpController.addLP("It's my life", "19.08.1986", "Queen", 223);
        lpController.addLP("It's my life", "19.08.1986", "Queen", 223);
        lpController.addLP("It's my life", "19.08.1986", "Queen", 223);
Run run = new Run();
    }
}
