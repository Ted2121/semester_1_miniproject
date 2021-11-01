package model;

import java.time.Period;

public class Loan {
    // TODO id gets incremented for every new order
    private int id;
    private String borrowDate;
    private String returnDate;
    // used a constant for the lending period
    private static final Period PERIOD = Period.ofDays(14);
    // true = lending completed successfully
    // false = lending failed
    private boolean state;

    public Loan(int loanNumber, String borrowDate) {
        this.id = loanNumber;
        this.borrowDate = borrowDate;

    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isState() {
        return state;
    }

    public int getId() {
        return id;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public boolean getState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public static Period getPERIOD() {
        return PERIOD;
    }
}