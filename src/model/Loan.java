package model;

import java.time.Period;
import java.util.ArrayList;

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
    private Person person;
    private LPCopy lpCopy;

    public Loan(int loanNumber, String borrowDate, Person person, LPCopy lpCopy) {
        this.id = loanNumber;
        this.borrowDate = borrowDate;
        this.person = person;
        this.lpCopy = lpCopy;
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

    @Override
    public String toString() {
        return "Loan " + id + "\n" +
                "borrowDate: " + borrowDate + "\n" +
                "returnDate: " + returnDate + "\n" +
                "----------------------------------------------";
    }
}
