package model;

import java.util.ArrayList;

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

    public void deletePerson(Person person) {
        persons.remove(person);
    }

    public void getInfo(){
        // used lambda to print each LPCopy
        persons.forEach(person -> System.out.println(person));
    }
}
