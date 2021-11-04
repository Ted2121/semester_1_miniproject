package model;

public class LP {
    private int barcode;
    private String title;
    private String artist;
    private String publicationDate;

    public LP(String title, String publicationDate, String artist, int barcode) {
        this.barcode = barcode;
        this.title = title;
        this.artist = artist;
        this.publicationDate = publicationDate;
    }


    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "LP title: " + title + "\n" +
                "artist: " + artist + "\n" +
                "publicationDate: " + publicationDate + "\n" +
                "barcode: " + barcode;
    }


    public String TitleToString() {
        return title;
    }
}
