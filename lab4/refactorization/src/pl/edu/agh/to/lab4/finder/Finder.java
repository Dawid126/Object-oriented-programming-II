package pl.edu.agh.to.lab4.finder;

import pl.edu.agh.to.lab4.search_strategies.SearchStrategy;
import pl.edu.agh.to.lab4.suspect_database.CompositeAgregate;
import pl.edu.agh.to.lab4.suspect_types.Suspect;

import java.util.ArrayList;
import java.util.Iterator;

public class Finder {
    private final CompositeAgregate compositeAgregate;
    private final SearchStrategy searchStrategy;

    public Finder(CompositeAgregate compositeAgregate, SearchStrategy searchStrategy) {
        this.compositeAgregate = compositeAgregate;
        this.searchStrategy = searchStrategy;
    }

    public void displayAllSuspectsWithName(String name) {
        ArrayList<Suspect> suspects = new ArrayList<Suspect>();

        Iterator<Suspect> suspectIterator = compositeAgregate.iterator();

        while(suspectIterator.hasNext() && suspects.size() < 10) {
           Suspect currentSuspect = suspectIterator.next();
            if (currentSuspect.canBeAccused() && currentSuspect.getName().equals(name)) {
                suspects.add(currentSuspect);
            }
        }

        int t = suspects.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Suspect n : suspects) {
            System.out.println(n.display());
        }
    }
}

