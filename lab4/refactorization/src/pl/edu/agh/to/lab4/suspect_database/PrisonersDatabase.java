package pl.edu.agh.to.lab4.suspect_database;

import pl.edu.agh.to.lab4.suspect_database.iterators.PrisonersIterator;
import pl.edu.agh.to.lab4.suspect_types.Prisoner;
import pl.edu.agh.to.lab4.suspect_types.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class PrisonersDatabase implements SuspectAgregate {

    private final Map<String, Collection<Prisoner>> prisoners;
    private final PrisonersIterator iterator;

    public PrisonersDatabase() {
        prisoners = new HashMap<String, Collection<Prisoner>>();
        addPrisoner("Wiezienie krakowskie", new Prisoner("Jan", "Kowalski", 1963, "87080452357", false));
        addPrisoner("Wiezienie krakowskie", new Prisoner("Anita", "Wiercipieta", 1973, "84080452357", false));
        addPrisoner("Wiezienie krakowskie", new Prisoner("Janusz", "Zlowieszczy", 1983, "92080445657", false));
        addPrisoner("Wiezienie przedmiejskie", new Prisoner("Janusz", "Zamkniety", 1993, "802104543357", true));
        addPrisoner("Wiezienie przedmiejskie", new Prisoner("Adam", "Future", 1992,"880216043357", true));
        addPrisoner("Wiezienie przedmiejskie", new Prisoner("Zbigniew", "Nienajedzony", 1991, "90051452335", false));
        addPrisoner("Wiezienie centralne", new Prisoner("Jan", "Przedziwny", 2000, "91103145223", false));
        addPrisoner("Wiezienie centralne", new Prisoner("Janusz", "Podejrzany", 1990,"85121212456", false));
        iterator = new PrisonersIterator(this);
    }

    public PrisonersDatabase(Map<String, Collection<Prisoner>> prisoners) {
        iterator = new PrisonersIterator(this);
        this.prisoners = prisoners;
    }

    public Iterator<Suspect> iterator() {
        return this.iterator;
    }

    public Map<String, Collection<Prisoner>> getAllPrisoners() {
        return prisoners;
    }

    public Collection<String> getAllPrisons() {
        return prisoners.keySet();
    }

    private void addPrisoner(String category, Prisoner prisoner) {
        if (!prisoners.containsKey(category))
            prisoners.put(category, new ArrayList<Prisoner>());
        prisoners.get(category).add(prisoner);
    }

}
