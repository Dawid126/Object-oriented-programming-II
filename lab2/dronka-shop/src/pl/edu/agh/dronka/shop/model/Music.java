package pl.edu.agh.dronka.shop.model;

public class Music extends Item {

    private MusicGenre genre;

    private boolean videoAdded;

    public Music(String name, Category category, int price, int quantity, MusicGenre genre, boolean videoAdded) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.genre = genre;
        this.videoAdded = videoAdded;
    }

    public Music() {
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setVideoAdded(boolean videoAdded) {
        this.videoAdded = videoAdded;
    }

    public boolean isVideoAdded() {
        return videoAdded;
    }
}
