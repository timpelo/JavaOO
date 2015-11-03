package W9E10to12;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jani on 1.11.2015.
 */

//MUUTOS KOE!!
public class Main {

    public static ArrayList<Person> personList;
    public static boolean exit = false;
    public static TimeSimulator time;

    public static void main(String[] args) {
        personList = new ArrayList<>();
        time = new TimeSimulator(personList);
        Scanner input = new Scanner(System.in);
        int command;

        while(!exit) {
            System.out.println();
            System.out.println("Enter command:");
            System.out.println("1. Create new person");
            System.out.println("2. Show all persons");
            System.out.println("3. Show detailed person info");
            System.out.println("4. Delete persons");
            System.out.println("5. Start/Pause time");
            System.out.println("0. Exit");
            System.out.println();
            do {
                command = input.nextInt();

                if(command < 1 && command > 5) {
                    System.out.println("Give correct command (1 - 4)!");
                }
            } while (command < 1 && command > 5);

            input.nextLine();
            executeCommand(command);
        }
    }

    public static void executeCommand(int command) {

        switch (command) {
            case 1:
                System.out.println("Enter person type:");
                System.out.println("1. Normal person");
                System.out.println("2. Programmer");
                System.out.println();

                int type = Integer.parseInt(askUserInput());

                System.out.println("Give name for person:");
                String name = askUserInput();

                if(type == 1) {
                    Person newPerson = new Person(name);

                    for(Person person: personList) {
                        newPerson.addObserver(person);
                        person.addObserver(newPerson);
                    }

                    personList.add(newPerson);
                }
                else if(type == 2) {
                    Person newPerson = new Programmer(name);

                    for(Person person: personList) {
                        newPerson.addObserver(person);
                        person.addObserver(newPerson);
                    }

                    personList.add(newPerson);
                }

                System.out.println("New person added to the list!");
                break;
            case 2:
                int personNumber = 1;
                for (Person person: personList) {
                    System.out.println(personNumber + ". " + person.getName() + ", age " + person.getAge());
                    personNumber ++;
                }
                break;
            case 3:
                System.out.println("Give number of the person:");
                int personInfo = Integer.parseInt(askUserInput());

                Person person = personList.get(personInfo -1);
                person.printInfo();
                System.out.println("Do you want to modify person info (Y/N)?");
                String modify = askUserInput();

                if(modify.equalsIgnoreCase("Y")) {
                    modifyPersonInfo(person);
                }
                break;
            case 4:
                System.out.println("Give number of person you want to remove: ");
                int index = Integer.parseInt(askUserInput());
                personList.remove(index - 1);
                break;
            case 5:
                time.setTimePaused(!time.isTimePaused());
                break;
            case 0:
                exit = true;
                System.exit(-1);
                break;
            default:
                System.out.println("Command not found!");
        }

        System.out.println();
    }

    public static String askUserInput() {

        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void modifyPersonInfo(Person person) {

        if(person instanceof Programmer) {
            System.out.println("Modify info:");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Spouse");
            System.out.println("4. Get drink!");
            System.out.println("5. Wage");
            System.out.println("0. Exit");
            System.out.println();
        } else {
            System.out.println("Modify info:");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Spouse");
            System.out.println("4. Get drink!");
            System.out.println("0. Exit");
            System.out.println();
        }

        int command = Integer.parseInt(askUserInput());

        switch (command) {
            case 1:
                System.out.println("Give new name: ");
                String name = askUserInput();
                person.setName(name);
                System.out.println("Name changed!");
                break;
            case 2:
                System.out.println("Give new age: ");
                int age = Integer.parseInt(askUserInput());
                person.setAge(age);
                System.out.println("Age changed!");
                break;
            case 3:
                System.out.println("Give name of the spouse: ");
                String spouseName = askUserInput();
                Person spouse = new Person(spouseName);
                person.setSpouse(spouse);
                System.out.println("Spouse added!");
                break;
            case 4:
                person.drink();
                break;
            case 5:
                if(person instanceof Programmer) {
                    System.out.println("Give new wage: ");
                    int wage  = Integer.parseInt(askUserInput());
                    ((Programmer) person).setWage(wage);
                    System.out.println("Wage changed!");
                }
                break;
            case 0:

                break;
            default:
                System.out.println("Command not found!");
        }

        System.out.println();

    }
}
