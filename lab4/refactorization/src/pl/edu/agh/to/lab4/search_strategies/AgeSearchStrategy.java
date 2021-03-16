package pl.edu.agh.to.lab4.search_strategies;

import pl.edu.agh.to.lab4.suspect_types.Suspect;

public class AgeSearchStrategy implements SearchStrategy{
    private int age;

    public AgeSearchStrategy(int age) {
        this.age = age;
    }

    public boolean filter(Suspect suspect) {
        return suspect.getAge() == this.age && suspect.canBeAccused();
    }
}
