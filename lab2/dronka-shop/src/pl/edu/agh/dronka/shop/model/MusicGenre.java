package pl.edu.agh.dronka.shop.model;

public enum MusicGenre {

    DISCOPOLO("Disco Polo"), RAP("Rap"), METAL("Metal"), SERBIANMILITARYMUSIC("Serbian military music");

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    private MusicGenre(String displayName) {
        this.displayName = displayName;
    }
}
