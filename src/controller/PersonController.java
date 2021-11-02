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

    public Person getStudentByName(String name){
       Person person = personContainer.getPersonByName(name);
        if(person == null){
            System.err.println("Person not in the database");
            System.out.println("Would you like to add a new person?");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            switch (answer){
                case "yes", "Yes" -> {System.out.println("Enter name: ");
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
                case "no", "No" -> System.out.println("Would you like to try again?");
                        String answer2 = scanner.next();
                        switch (answer2){
                            case "yes", "Yes" -> getStudentByName(name);
                            default -> System.exit(0);

                }
            }
        }

    }
}
