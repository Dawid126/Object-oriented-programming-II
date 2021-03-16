package pl.edu.agh.internetshop;

import java.util.ArrayList;
import java.util.Collection;

public class CompositeSearchStrategy implements SearchStrategy{
    private ArrayList<SearchStrategy> childSearchStrategy = new ArrayList<>();

    public CompositeSearchStrategy(Collection<SearchStrategy> searchStrategies) {
        this.childSearchStrategy.addAll(searchStrategies);
    }

    public boolean filter(Order order) {
        for(SearchStrategy searchStrategy: childSearchStrategy) {
            if(!searchStrategy.filter(order)) {
                return false;
            }
        }
        return true;
    }
}
