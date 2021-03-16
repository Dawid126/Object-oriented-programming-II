package pl.edu.agh.to.lab4.suspect_database;

import pl.edu.agh.to.lab4.suspect_types.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CompositeAgregate implements SuspectAgregate {
    private ArrayList<SuspectAgregate> childSuspectAgregate = new ArrayList<>();
    private Iterator<Suspect> iterator;

    public CompositeAgregate(Collection<SuspectAgregate> suspectAgregates) {
        childSuspectAgregate.addAll(suspectAgregates);
        ArrayList<Suspect> suspects = new ArrayList<>();

        for(SuspectAgregate agregate: childSuspectAgregate) {
            Iterator<Suspect> suspectIterator = agregate.iterator();

            while(suspectIterator.hasNext()) {
                suspects.add(suspectIterator.next());
            }
        }
        this.iterator = suspects.iterator();
    }

    public Iterator<Suspect> iterator() {
        return this.iterator;
    }
}
