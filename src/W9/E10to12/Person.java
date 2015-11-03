package W9.E10to12;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

/**
 * Created by Jani on 1.11.2015.
 */
public class Person {
    Random rand;

    private String name;
    private boolean passedOut = false;
    private int age;
    private String gender;
    private Optional<Person> spouse;
    private ArrayList<Person> observerList;
    private int libido;
    private int attractiveness;
    private int alcoholLevel;

    public Person(String name) {
        rand = new Random();
        this.name = name;
        spouse = Optional.ofNullable(null);
        alcoholLevel = 0;
        observerList = new ArrayList<>();

        age = rand.nextInt(90) + 10;
        libido = rand.nextInt(100);
        attractiveness = rand.nextInt(100);

        int gender = rand.nextInt(1);

        switch (gender) {
            case 0:
                this.gender = "male";
                break;
            case 1:
                this.gender = "female";
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if(age > 0) {
            this.age = age;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender.equals("male") || gender.equals("female")) {
            this.gender = gender;
        }
    }

    public Optional<Person> getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = Optional.ofNullable(spouse);
    }

    public int getLibido() {
        return libido;
    }

    public void setLibido(int libido) {

        if(libido >= 0 && libido <= 100) {
            this.libido = libido;
        }
    }

    public int getAttractiveness() {
        return attractiveness;
    }

    public void setAttractiveness(int attractiveness) {
        if(attractiveness >= 0 && attractiveness <= 100) {
            this.attractiveness = attractiveness;
        }
    }

    public int getAlcoholLevel() {
        return alcoholLevel;
    }

    public void setAlcoholLevel(int alcoholLevel) {
        this.alcoholLevel = alcoholLevel;
    }

    public boolean isPassedOut() {
        return passedOut;
    }

    public void setPassedOut(boolean passedOut) {
        this.passedOut = passedOut;
    }

    public void printInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Gender: " + getGender());
        System.out.println("Age: " + getAge());
        getSpouse().ifPresent(spouse -> System.out.println("Spouse: " + spouse.getName()));
        System.out.println("Libido: " + getLibido());
        System.out.println("Attractiveness: " + getAttractiveness());
    }

    public void drink() {
        if(!isPassedOut()) {
            alcoholLevel += 5;

            if (alcoholLevel < 30) {
                setLibido(getLibido() + 1);
            }

            if (libido > 20) {
                notifyAllObservers();
            }

            System.out.println(getName() + " drinks!!");
        }
    }

    public void addObserver(Person p) {
        observerList.add(p);
    }

    public void notifyLibido(LibidoEvent e) {


        if(!getSpouse().isPresent() && !e.getHost().getSpouse().isPresent()) {

            if (e.getPrecentage() == getLibido()) {
                setSpouse(e.getHost());
                e.getHost().setSpouse(this);

                System.out.println();
                System.out.println();
                System.out.println("!!!JUST MARRIED!!!");
                System.out.println(e.getHost().getName() + " married " + this.getName());
                System.out.println();
                System.out.println();
            }
        }

    }

    public void notifyAllObservers() {

        for(Person p: observerList) {
            p.notifyLibido(new LibidoEvent(getLibido(), this));
        }
    }
}
