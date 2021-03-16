package pl.edu.agh.to.lab4.suspect_database.iterators;

import pl.edu.agh.to.lab4.suspect_database.PrisonersDatabase;
import pl.edu.agh.to.lab4.suspect_types.Prisoner;
import pl.edu.agh.to.lab4.suspect_types.Suspect;

import java.util.*;

public class PrisonersIterator implements Iterator<Suspect> {
    private ArrayList<Iterator<Prisoner>> suspects = new ArrayList<>();
    private int counter = 0;

    public PrisonersIterator(PrisonersDatabase prisonersDatabase)
    {
        for (Collection<Prisoner> prisonerCollection : prisonersDatabase.getAllPrisoners().values()) {
            suspects.add(prisonerCollection.iterator());
        }
    }

    @Override
    public boolean hasNext()
    {
        return suspects.get(this.suspects.size() -1).hasNext();
    }

    @Override
    public Suspect next()
    {
        if(!suspects.get(counter).hasNext()) {
            counter++;
        }
        return suspects.get(counter).next();
    }
}

