package pl.edu.agh.to.lab4.search_strategies;

import pl.edu.agh.to.lab4.suspect_types.Suspect;

public interface SearchStrategy {
    boolean filter(Suspect suspect);
}
