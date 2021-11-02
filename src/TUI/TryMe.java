package TUI;


import controller.LPController;


public class TryMe {

    LPController lpController = new LPController();

    public TryMe(){

        //LPController lpController = new LPController();
        lpController.addLP("Bohemian Rhapsody", "19.08.1986", "Queen", 223);
        lpController.addLP("Bohemian Rhapsody", "19.08.1986", "Queen", 223);
        lpController.addLP("Bohemian Rhapsody", "19.08.1986", "Queen", 223);

        //lpController.getInfo();

        lpController.addLPCopy("test1", "19.08.1986", "Queen", 223, 1, false);
        lpController.addLPCopy("test2", "19.08.1986", "Queen", 223, 1, false);
        lpController.addLPCopy("test true", "19.08.1986", "Queen", 223, 1, true);
        lpController.addLPCopy("test 3", "19.08.1986", "Queen", 223, 1, false);
        lpController.addLPCopy("test true 2", "19.08.1986", "Queen", 223, 1, true);

        // successfull test for getFirstCopyAvailable method
        System.out.println(lpController.getFirstCopyAvail(lpController.getLpCopyContainer().getLpCopies()));


//        lpController.addLP("It's my life", "19.08.1986", "Queen", 223);
//        lpController.addLPCopy("It's my life", "19.08.1986", "Queen", 223, 1, true);
//
//        LPCopy lpCopy = new LPCopy("It's my life", "19.08.1986", "Queen", 223, 1, true);
//        lpController.addLPCopy(lpCopy);
    }
}
