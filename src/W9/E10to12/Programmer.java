package W9.E10to12;

import java.util.Random;

/**
 * Created by Jani on 1.11.2015.
 */
public class Programmer extends Person {

    private double wage;

    public Programmer(String name) {
        super(name);
        setAttractiveness(0);

        Random rand = new Random();
        setLibido(rand.nextInt(20));
        wage = rand.nextInt(4000) + 1000;
    }

    @Override
    public void setAttractiveness(int attractiveness) {

    }

    @Override
    public void printInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Gender: " + getGender());
        System.out.println("Age: " + getAge());
        getSpouse().ifPresent(spouse -> System.out.println("Spouse: " + spouse.getName()));
        System.out.println("Libido: " + getLibido());
        System.out.println("Attractiveness: " + getAttractiveness());
        System.out.println("Wage: " + getWage());
    }

    public void giveRaise(double d) {
        wage += d;
        setLibido(getLibido() + 1);
    }

    @Override
    public void drink() {

        if(!isPassedOut()) {

            setAlcoholLevel(getAlcoholLevel() + 1);

            if (getAlcoholLevel() > 10) {
                setPassedOut(true);
                setLibido(0);
            }
        }
    }

    public double getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }
}
