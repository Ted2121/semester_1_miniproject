package model;

import java.time.LocalDate;
import java.time.Period;

public class Loan {
    // TODO id gets incremented for every new order
    private int id;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    // used a constant for the lending period
    //private static final long PERIOD = 14;
    // true = lending completed successfully
    // false = lending failed
    private boolean state;
    private Person person;
    private LPCopy lpCopy;

    public Loan(int id, LocalDate borrowDate, Person person, LPCopy lpCopy) {
        this.id = id;
        // TODO setborrowdate in controller and container
        this.borrowDate = borrowDate;
        this.person = person;
        this.lpCopy = lpCopy;

    }

//    public Loan(int id, LocalDate borrowDate, LocalDate returnDate, Person person, LPCopy lpCopy) {
//        this.id = id;
//        this.borrowDate = borrowDate;
//        this.returnDate = returnDate;
//        this.person = person;
//        this.lpCopy = lpCopy;
//    }

    public Loan(int id, LocalDate borrowDate) {
        this.id = id;
        // TODO setborrowdate in controller and container
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isState() {
        return state;
    }

    public int getId() {
        return id;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public boolean getState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setState(boolean state) {
        this.state = state;
    }

//    public static long getPERIOD() {
//        return PERIOD;
//    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public LPCopy getLpCopy() {
        return lpCopy;
    }

    public void setLpCopy(LPCopy lpCopy) {
        this.lpCopy = lpCopy;
    }



    @Override
    public String toString() {
        return "Loan " + id + "\n" +
                "borrowDate: " + borrowDate + "\n" +
                "returnDate: " + returnDate + "\n" +
                "LP: " + lpCopy.toString() + "\n" +
                "Person: " + person.toString() + "\n" +
                "----------------------------------------------";
    }
}
