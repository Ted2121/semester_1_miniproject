package controller;


import model.Person;
import model.PersonContainer;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class PersonController {
    private PersonContainer personContainer;
    Person person;

    public PersonController(){
        personContainer = PersonContainer.getInstance();
    }

    public Person addPerson(String name, String address, int postalCode, String city, int phoneNumber){
        person = new Person(name, address, postalCode, city, phoneNumber);
        personContainer.addPerson(person);
        return person;
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

    public Person getPersonByName(String name){
       Person person = personContainer.getPersonByName(name);
        if(person == null){
            System.err.println("Person not in the database");
            System.out.println("Would you like to add a new person?");
            Scanner scanner = new Scanner(System.in);
            String answer1 = scanner.next();
            switch (answer1){
                case "yes", "Yes" -> {
                    person = createNewPersonText();
                    return person;
                }
                default -> {

                    String answer2 = tryAgain();
                    switch (answer2){
                        case "yes", "Yes" -> getPersonByName(name);
                        default -> System.exit(0);
            }
                }
            }
        }
return person;
    }

    public Person getPersonByPhoneNumber(int phoneNum){
        Person person = personContainer.getPersonByPhoneNumber(phoneNum);
        if(person == null){
            System.err.println("Person not in the database");
            System.out.println("Would you like to add a new person?");
            Scanner scanner = new Scanner(System.in);
            String answer1 = scanner.next();
            switch (answer1){
                case "yes", "Yes" -> {
                    person = createNewPersonText();
                    return person;
                }
                default -> {

                    String answer2 = tryAgain();
                    switch (answer2){
                        case "yes", "Yes" -> getPersonByPhoneNumber(phoneNum);
                        default -> System.exit(0);
                    }
                }
            }
        }
        return person;
    }

private String tryAgain(){
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        return answer;
}

    public Person createNewPersonText(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String newName = scanner.next();
        System.out.println("Enter address: ");
        String address = scanner.next();
        System.out.println("Enter postal code: ");
        int postalCode = scanner.nextInt();
        System.out.println("Enter city: ");
        String city = scanner.next();
        System.out.println("Enter phoneNumber: ");
        int phoneNumber = scanner.nextInt();

        return addPerson(newName, address, postalCode, city, phoneNumber);
    }

}
