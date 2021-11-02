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

    // TODO garbage?
    // gets called after an LP is returned
    public void deletePerson(Person person){
        personContainer.deletePerson(person);
    }

    // TODO garbage?
    // for populating the containers
//    public void addPerson(Person person) {
//        personContainer.addPerson(person);
//    }

    public Person getStudentByName(String name){
        return personContainer.getPersonByName(name);
    }
}
