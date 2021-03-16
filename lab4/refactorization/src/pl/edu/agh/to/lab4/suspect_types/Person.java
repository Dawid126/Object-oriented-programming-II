package pl.edu.agh.to.lab4.suspect_types;

import java.util.Calendar;

public class Person extends Suspect {
    private final int yearOfBirth;

    public Person(String name, String lastName, int yearOfBirth) {
        super(name, lastName, yearOfBirth);
        this.yearOfBirth = yearOfBirth;
    }

    public int getAge() {
        return getCurrentYear() - this.yearOfBirth;
    }

    private static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public boolean canBeAccused () {
        return this.getAge() >= 18;
    }
}
