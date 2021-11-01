package controller;


import model.Person;
import model.PersonContainer;

public class PersonController {
    private PersonContainer personContainer;

    public PersonController(){
        personContainer = PersonContainer.getInstance();
    }

    public void addPerson(String name, String address, int postalCode, String city, int phoneNumber){
        personContainer.addPerson(new Person(name, address, postalCode, city, phoneNumber));
    }

    // gets called after an LP is returned
    public void deletePerson(Person person){
        deletePerson(person);
    }

    // for populating the containers
    public void addPerson(Person person) {
        personContainer.addPerson(person);
    }


}
