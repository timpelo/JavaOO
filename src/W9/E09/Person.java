package W9.E09;

import java.util.Optional;
import java.util.Random;

/**
 * Created by Jani on 1.11.2015.
 */
public class Person {
    Random rand;

    private String name;
    private int age;
    private String gender;
    private Optional<Person> spouse;
    private int libido;
    private int attractiveness;

    public Person(String name) {
        rand = new Random();
        this.name = name;
        spouse = Optional.ofNullable(null);

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

    public void printInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Gender: " + getGender());
        System.out.println("Age: " + getAge());
        getSpouse().ifPresent(spouse -> System.out.println("Spouse: " + spouse.getName()));
        System.out.println("Libido: " + getLibido());
        System.out.println("Attractiveness: " + getAttractiveness());
    }
}
