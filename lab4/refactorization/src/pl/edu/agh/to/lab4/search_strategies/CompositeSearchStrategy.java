package pl.edu.agh.to.lab4.search_strategies;

import pl.edu.agh.to.lab4.suspect_types.Suspect;

import java.util.ArrayList;
import java.util.Collection;

public class CompositeSearchStrategy implements SearchStrategy{
    private ArrayList<SearchStrategy> childSearchStrategy = new ArrayList<>();

    public CompositeSearchStrategy(Collection<SearchStrategy> searchStrategies) {
        this.childSearchStrategy.addAll(searchStrategies);
    }

    public boolean filter(Suspect suspect) {
        for(SearchStrategy searchStrategy: childSearchStrategy) {
            if(!searchStrategy.filter(suspect)) {
                return false;
            }
        }
        return true;
    }
}
