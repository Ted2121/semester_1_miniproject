package model;

public class Person {
    private String name;
    private String address;
    private int postalCode;
    private String city;
    private int phoneNumber;

    public Person(String name, String address, int postalCode, String city, int phoneNumber) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n" +
                "address: " + address + "\n" +
                "postal code: " + postalCode + "\n" +
                "city: " + city + "\n" +
                "phone number: " + phoneNumber + "\n" +
                "----------------------------------------------";
    }
}
