package pl.edu.agh.to.lab4.suspect_types;

import java.util.Calendar;

public abstract class Suspect {
    private final String name;
    private final String lastName;
    private final int yearOfBirth;

    public Suspect(String name, String lastName, int yearOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String display() {
        return name + " " + lastName;
    }

    public int getAge() {
        return getCurrentYear() - this.yearOfBirth;
    }

    private static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public abstract boolean canBeAccused();
}
