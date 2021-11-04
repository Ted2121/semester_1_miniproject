package model;

import java.time.LocalDate;

public class Loan {

    private int id;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Person person;
    private LPCopy lpCopy;

    public Loan(int id, LocalDate borrowDate) {
        this.id = id;
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
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
