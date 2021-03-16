package pl.edu.agh.to.lab4.suspect_database;

import pl.edu.agh.to.lab4.suspect_types.Suspect;

import java.util.Iterator;

public interface SuspectAgregate {
    Iterator<Suspect> iterator();
}
