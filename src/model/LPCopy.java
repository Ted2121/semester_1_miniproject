package model;

public class LPCopy extends LP{

    private int serialNumber;
    // true = book is available
    // false = book is not available
    private boolean state;

    public LPCopy(String title, String publicationDate, String artist, int barcode, int serialNumber, boolean state) {
        super(title, publicationDate, artist, barcode);
        this.serialNumber = serialNumber;
        this.state = state;
    }



    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        String availability = "unavailable";
        if (state) availability = "available";

        return super.toString() + "\n" +
                "serial number: " + serialNumber + "\n" +
                "state is now: " + availability + "\n" +
                "----------------------------------------------";
    }
}
