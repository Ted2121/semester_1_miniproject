package TUI;


import controller.LPController;


public class TryMe {

    LPController lpController = new LPController();

    public TryMe(){

        //LPController lpController = new LPController();
        lpController.addLP("Bohemian Rhapsody", "19.08.1986", "Queen", 223);
        lpController.addLP("Radio gaga", "19.08.1986", "Queen", 223);
        lpController.addLP("Bohemian Rhapsody", "19.08.1986", "Queen", 223);

        //lpController.getInfo();

        // TODO title gets messed up
        lpController.addLPCopy("test1", "19.08.1986", "Queen", 223, 1, true);
        lpController.addLPCopy("test2", "19.08.1986", "Queen", 223, 1, true);
        lpController.addLPCopy("Bohemian Rhapsody", "19.08.1986", "Queen", 220, 1, true);
        lpController.addLPCopy("Radio gaga", "19.08.1986", "Queen", 221, 1, true);
        lpController.addLPCopy("Radio gaga", "19.08.1986", "Queen", 224, 1, true);


        // successfull test for getFirstCopyAvailable method
        // System.out.println(lpController.getFirstCopyAvail(lpController.getLpCopyContainer().getLpCopies(), "test1"));


//        lpController.addLP("It's my life", "19.08.1986", "Queen", 223);
//        lpController.addLPCopy("It's my life", "19.08.1986", "Queen", 223, 1, true);
//
//        LPCopy lpCopy = new LPCopy("It's my life", "19.08.1986", "Queen", 223, 1, true);
//        lpController.addLPCopy(lpCopy);
    }
}
