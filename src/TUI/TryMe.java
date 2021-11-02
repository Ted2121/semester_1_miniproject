package TUI;


import controller.LPController;


public class TryMe {

    LPController lpController = new LPController();

    public TryMe(){

        //LPController lpController = new LPController();
        lpController.addLP("Bohemian Rhapsody", "19.08.1986", "Queen", 223);
        lpController.addLP("Bohemian Rhapsody", "19.08.1986", "Queen", 223);
        lpController.addLP("Bohemian Rhapsody", "19.08.1986", "Queen", 223);

        lpController.getInfo();



//        lpController.addLP("It's my life", "19.08.1986", "Queen", 223);
//        lpController.addLPCopy("It's my life", "19.08.1986", "Queen", 223, 1, true);
//
//        LPCopy lpCopy = new LPCopy("It's my life", "19.08.1986", "Queen", 223, 1, true);
//        lpController.addLPCopy(lpCopy);
    }
}
