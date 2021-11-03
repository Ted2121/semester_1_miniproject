package model;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonContainer {


    private ArrayList<Person> persons;
    private static PersonContainer instance;

    private PersonContainer(){
        persons = new ArrayList<Person>();
    }

    // singleton
    public static PersonContainer getInstance(){
        if(instance==null)
            instance = new PersonContainer();
        return instance;
    }

    // part of CRUD Person
    public void addPerson(Person person){
        persons.add(person);
    }

    // part of CRUD Person
    public void deletePerson(Person person) {
        persons.remove(person);
    }

    public void getInfo(){
        // used lambda to print each LPCopy
        persons.forEach(person -> System.out.println(person));
    }

    public Person getPersonByName(String name){

        boolean found = false;
        int i = 0;
        while(!found && i<persons.size()){
            if(persons.get(i).getName().equals(name))
                found = true;
            else
                i++;
        }
        if(found)
            return persons.get(i);
        else{

            return null;}
    }

    public Person getPersonByPhoneNumber(int phoneNum){
        Person person = null;
        boolean found = false;
        int i = 0;
        while(!found && i < persons.size()){
            if(persons.get(i).getPhoneNumber() == phoneNum) {
                person = persons.get(i);
                found = true;
                return person;
            }else {
                i++;
            }
        }
        return person;
    }

    // part of CRUD Person
    public void updatePersonName(Person person, String name){
        person.setName(name);
    }

    // part of CRUD Person
    public void updatePersonAddress(Person person, String address){
        person.setAddress(address);
    }

    // part of CRUD Person
    public void updatePersonPostalCode(Person person, int postalCode){
        person.setPostalCode(postalCode);
    }

    // part of CRUD Person
    public void updatePersonCity(Person person, String city){
        person.setCity(city);
    }

    // part of CRUD Person
    public void updatePersonPhoneNumber(Person person, int phoneNumber){
        person.setPhoneNumber(phoneNumber);
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }



}
