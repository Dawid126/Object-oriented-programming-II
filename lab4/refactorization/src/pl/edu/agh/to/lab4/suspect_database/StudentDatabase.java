package pl.edu.agh.to.lab4.suspect_database;

import pl.edu.agh.to.lab4.suspect_types.Student;
import pl.edu.agh.to.lab4.suspect_types.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StudentDatabase implements SuspectAgregate{

    private final Collection<Student> cracovStudents;

    public StudentDatabase() {
        cracovStudents = new ArrayList<>();
        cracovStudents.add(new Student("Zbyszko", "Zbogdanca", 1990, 345678));
        cracovStudents.add(new Student("Jurand", "Zespychowa", 1980, 234567));
        cracovStudents.add(new Student("Wladyslaw", "Jagiello", 2010, 654321));
        cracovStudents.add(new Student("Janusz", "Student", 1990, 123456));
    }

    public  StudentDatabase(Collection<Student> cracovStudents) {
        this.cracovStudents = cracovStudents;
    }

    public Iterator<Suspect> iterator() {
        ArrayList<Suspect> suspectArrayList = new ArrayList<Suspect>(cracovStudents);
        return suspectArrayList.iterator();
    }

    public Collection<Student> getAllCracovStudents() {
        return cracovStudents;
    }

    private void addCracovStudent(Student student) {
        if (!cracovStudents.contains(student))
            cracovStudents.add(student);
    }
}
