package TUI;

public class Run {
    MainMenu mainMenu;
    TryMe tryMe;

    public Run(){
        tryMe = new TryMe();
        mainMenu = new MainMenu();

    }
    public static void main(String[] args) {

    new Run().mainMenu.start();

    }
}
