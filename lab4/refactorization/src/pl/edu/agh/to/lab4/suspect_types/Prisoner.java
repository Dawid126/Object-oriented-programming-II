package pl.edu.agh.to.lab4.suspect_types;


public class Prisoner extends Suspect {
    private final String ID;
    private boolean isJailedNow;

    public Prisoner(String name, String lastName, int yearOfBirth, String ID, boolean isJailedNow) {
        super(name, lastName, yearOfBirth);
        this.ID = ID;
        this.isJailedNow = isJailedNow;
    }

    public String getID() {
        return ID;
    }

    public boolean isJailedNow() {
        return this.isJailedNow;
    }

    public void setJailStatus(boolean isJailedNow) {
        this.isJailedNow = isJailedNow;
    }

    public boolean canBeAccused () {
        return !this.isJailedNow();
    }

}
