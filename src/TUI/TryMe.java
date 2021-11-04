package TUI;


import controller.LPController;
import controller.LoanController;
import controller.PersonController;


public class TryMe {

    LPController lpController = new LPController();
    LoanController loanController = new LoanController();
    PersonController personController = new PersonController();


    public TryMe(){

        lpController.addLP("Bohemian Rhapsody", "19.08.1986", "Queen", 76576);
        lpController.addLP("Radio gaga", "14.08.1983", "Queen", 67578);
        lpController.addLP("It's my life", "19.08.1956", "Bon Jovi", 34563);
        lpController.addLP("Oceans", "20.05.2018", "Charlotte Cardin", 49863);
        lpController.addLP("Nocturne", "29.01.1833", "Chopin" , 37663);

        lpController.addLPCopy("Bohemian Rhapsody", "19.08.1986", "Queen", 220, 1, true);
        lpController.addLPCopy("Bohemian Rhapsody", "19.08.1986", "Queen", 221, 2, false);
        lpController.addLPCopy("Bohemian Rhapsody", "19.08.1986", "Queen", 222, 3, true);
        lpController.addLPCopy("Bohemian Rhapsody", "19.08.1986", "Queen", 223, 4, false);
        lpController.addLPCopy("Bohemian Rhapsody", "19.08.1986", "Queen", 224, 5, true);

        lpController.addLPCopy("Radio gaga", "14.08.1983", "Queen", 320, 6, false);
        lpController.addLPCopy("Radio gaga", "14.08.1983", "Queen", 321, 7, true);
        lpController.addLPCopy("Radio gaga", "14.08.1983", "Queen", 322, 8, true);
        lpController.addLPCopy("Radio gaga", "14.08.1983", "Queen", 323, 9, true);
        lpController.addLPCopy("Radio gaga", "14.08.1983", "Queen", 324, 10, false);

        lpController.addLPCopy("It's my life", "12.03.1956", "Bon Jovi", 420, 11, true);
        lpController.addLPCopy("It's my life", "12.03.1956", "Bon Jovi", 421, 12, false);
        lpController.addLPCopy("It's my life", "12.03.1956", "Bon Jovi", 422, 13, false);
        lpController.addLPCopy("It's my life", "12.03.1956", "Bon Jovi", 423, 14, true);
        lpController.addLPCopy("It's my life", "12.03.1956", "Bon Jovi", 424, 15, true);

        lpController.addLPCopy("Oceans", "20.05.2018", "Charlotte Cardin", 520, 16, false);
        lpController.addLPCopy("Oceans", "20.05.2018", "Charlotte Cardin", 521, 17, true);
        lpController.addLPCopy("Oceans", "20.05.2018", "Charlotte Cardin", 522, 18, true);
        lpController.addLPCopy("Oceans", "20.05.2018", "Charlotte Cardin", 523, 19, false);
        lpController.addLPCopy("Oceans", "20.05.2018", "Charlotte Cardin", 524, 20, true);

        lpController.addLPCopy("Nocturne", "29.01.1833", "Chopin", 420, 21, true);
        lpController.addLPCopy("Nocturne", "29.01.1833", "Chopin", 421, 22, true);
        lpController.addLPCopy("Nocturne", "29.01.1833", "Chopin", 422, 23, false);
        lpController.addLPCopy("Nocturne", "29.01.1833", "Chopin", 423, 24, false);
        lpController.addLPCopy("Nocturne", "29.01.1833", "Chopin", 424, 25, true);

        personController.addPerson("Ted", "Letvadvej 3A", 9200, "Aalborg", 31896135);
        personController.addPerson("Andreea", "Vesterbro 11", 9000, "Aalborg", 43214325);
        personController.addPerson("Rares", "Nibevej 12", 9000, "Aalborg", 42343255);
        personController.addPerson("Akos", "Parkvej 15", 9000, "Aalborg", 54365664);
        personController.addPerson("Vladdy", "Nibevej 16", 9200, "Aalborg", 97685767);

    }
}
