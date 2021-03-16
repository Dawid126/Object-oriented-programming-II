package pl.edu.agh.to.lab4.suspect_types;

public class Student extends Suspect {
    private final int index;

    public Student(String name, String lastName, int yearOfBirth, int index) {
        super(name, lastName, yearOfBirth);
        this.index = index;
    }

    public boolean canBeAccused () {
        return this.getAge() >= 18;
    }
}
