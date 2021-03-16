package pl.edu.agh.to.lab4.search_strategies;

import pl.edu.agh.to.lab4.suspect_types.Suspect;

public class NameSearchStrategy implements SearchStrategy{
    private String name;

    public NameSearchStrategy(String name) {
        this.name = name;
    }

    public boolean filter(Suspect suspect) {
        return suspect.getName().equals(this.name) && suspect.canBeAccused();
    }
}
