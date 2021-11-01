package model;

import java.time.LocalDate;

public class LPCopy extends LP{

    private int serialNumber;
    // true = book is available
    // false = book is not available
    private boolean state;

    public LPCopy(int barcode, String title, String artist, String publicationDate, int serialNumber, boolean state) {
        super(barcode, title, artist, publicationDate);
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
}
