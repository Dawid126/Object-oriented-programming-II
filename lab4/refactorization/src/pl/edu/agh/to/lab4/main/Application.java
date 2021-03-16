package pl.edu.agh.to.lab4.main;

import pl.edu.agh.to.lab4.finder.Finder;
import pl.edu.agh.to.lab4.search_strategies.AgeSearchStrategy;
import pl.edu.agh.to.lab4.search_strategies.CompositeSearchStrategy;
import pl.edu.agh.to.lab4.search_strategies.NameSearchStrategy;
import pl.edu.agh.to.lab4.search_strategies.SearchStrategy;
import pl.edu.agh.to.lab4.suspect_database.*;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        ArrayList<SuspectAgregate> suspectAgregates = new ArrayList<>();
        ArrayList<SearchStrategy> searchStrategies = new ArrayList<>();
        suspectAgregates.add(new PersonDataProvider());
        suspectAgregates.add(new PrisonersDatabase());
        suspectAgregates.add(new StudentDatabase());

        searchStrategies.add(new NameSearchStrategy("Janusz"));
        searchStrategies.add(new AgeSearchStrategy(30));

        Finder finder = new Finder(new CompositeAgregate(suspectAgregates), new CompositeSearchStrategy(searchStrategies));
        finder.displayAllSuspectsWithName("Janusz");
    }
}
