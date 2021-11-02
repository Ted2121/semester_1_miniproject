package TUI;


import controller.LPController;
import controller.LoanController;
import controller.PersonController;


public class TryMe {

    LPController lpController = new LPController();
    LoanController loanController = new LoanController();
    PersonController personController = new PersonController();


    public TryMe(){

        //LPController lpController = new LPController();
        lpController.addLP("Bohemian Rhapsody", "19.08.1986", "Queen", 76576);
        lpController.addLP("Radio gaga", "11.05.1988", "Queen", 67578);
        lpController.addLP("It's my life", "29.09.1976", "Bon Jovi", 34563);
        lpController.addLP("Oceans", "20.05.2018", "CHarlotte Cardin", 34563);
        lpController.addLP("Where did you sleep last night", "23.11.1992", "Nirvana" , 34563);

        //lpController.getInfo();

        lpController.addLPCopy("wtf", "19.08.1986", "Queen", 223, 1, true);
        lpController.addLPCopy("test2", "19.08.1986", "Queen", 223, 1, true);
        lpController.addLPCopy("Bohemian Rhapsody", "19.08.1986", "Queen", 220, 1, true);
        lpController.addLPCopy("Radio gaga", "19.08.1986", "Queen", 221, 1, true);
        lpController.addLPCopy("Radio gaga", "19.08.1986", "Queen", 224, 1, true);

        personController.addPerson("Ted", "Letvadvej 3A", 9200, "Aalborg", 31896135);
        personController.addPerson("Andreea", "Vesterbro 11", 9000, "Aalborg", 43214325);
        personController.addPerson("Rares", "Nibevej 12", 9000, "Aalborg", 42343255);
        personController.addPerson("Akos", "Parkvej 15", 9000, "Aalborg", 54365664);
        personController.addPerson("Vladdy", "Nibevej 14", 9200, "Aalborg", 97685767);



        // successfull test for getFirstCopyAvailable method
        // System.out.println(lpController.getFirstCopyAvail(lpController.getLpCopyContainer().getLpCopies(), "test1"));


//        lpController.addLP("It's my life", "19.08.1986", "Queen", 223);
//        lpController.addLPCopy("It's my life", "19.08.1986", "Queen", 223, 1, true);
//
//        LPCopy lpCopy = new LPCopy("It's my life", "19.08.1986", "Queen", 223, 1, true);
//        lpController.addLPCopy(lpCopy);
    }
}
