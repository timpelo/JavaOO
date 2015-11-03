package W9.E10to12;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jani on 1.11.2015.
 */
public class TimeSimulator implements Runnable{

    ArrayList<Person> personList;
    String[] names = {"Jaako", "Sanni", "Mervi", "Heimo", "Timo", "Turbohuulijuha", "Jukka", "Henna", "Harri"};
    private int year;
    private boolean timePaused = false;

    public TimeSimulator(ArrayList<Person> personList) {
        this.personList = personList;
        year = 2000;
        generateTestPerson();
        (new Thread(this)).start();
    }

    @Override
    public void run() {
        while(true) {

            while(isTimePaused()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(1000);
                year++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (Person person : personList) {
                updatePerson(person);
            }

        }
    }

    public void updatePerson(Person person) {
        Random rand = new Random();
        int drink = rand.nextInt(10);

        person.setAge(person.getAge() + 1);
        person.setLibido(person.getLibido() + 1);

        if(drink == 5) {
            person.drink();
        }
    }

    public void generateTestPerson() {

        for (int i = 0; i < names.length; i++) {
            Person newPerson = new Person(names[i]);

            for (Person person : personList) {
                newPerson.addObserver(person);
                person.addObserver(newPerson);
            }

            personList.add(newPerson);
        }

    }

    public boolean isTimePaused() {
        return timePaused;
    }

    public void setTimePaused(boolean timePaused) {
        this.timePaused = timePaused;

        if(isTimePaused()) {
            System.out.println("Time is paused!");
        } else {
            System.out.println("Time is running!");
        }
    }
}
