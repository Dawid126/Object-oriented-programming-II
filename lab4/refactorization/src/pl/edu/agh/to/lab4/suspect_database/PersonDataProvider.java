package pl.edu.agh.to.lab4.suspect_database;

import pl.edu.agh.to.lab4.suspect_types.Person;
import pl.edu.agh.to.lab4.suspect_types.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PersonDataProvider implements SuspectAgregate{

    private final Collection<Person> cracovCitizens;

    public PersonDataProvider() {
        cracovCitizens = new ArrayList<>();
        cracovCitizens.add(new Person("Jan", "Kowalski", 1990));
        cracovCitizens.add(new Person("Janusz", "Obywatel", 1990));
        cracovCitizens.add(new Person("Janusz", "Mlodociany", 2010));
        cracovCitizens.add(new Person("Kasia", "Kosinska", 2001));
        cracovCitizens.add(new Person("Piotr", "Zgredek", 1991));
        cracovCitizens.add(new Person("Tomek", "Gimbus", 2006));
        cracovCitizens.add(new Person("Janusz", "Gimbus", 2005));
        cracovCitizens.add(new Person("Alicja", "Zaczarowana", 1998));
        cracovCitizens.add(new Person("Janusz", "Programista", 1948));
        cracovCitizens.add(new Person("Pawel", "Pawlowicz", 1982));
        cracovCitizens.add(new Person("Krzysztof", "Mendel", 1990));
    }

    public  PersonDataProvider(Collection<Person> cracovCitizens) {
        this.cracovCitizens = cracovCitizens;
    }

    public Iterator<Suspect> iterator() {
        ArrayList<Suspect> suspectArrayList = new ArrayList<Suspect>(cracovCitizens);
        return suspectArrayList.iterator();
    }

    public Collection<Person> getAllCracovCitizens() {
        return cracovCitizens;
    }

    private void addCracovCitizen(Person person) {
        if (!cracovCitizens.contains(person))
            cracovCitizens.add(person);
    }
}
