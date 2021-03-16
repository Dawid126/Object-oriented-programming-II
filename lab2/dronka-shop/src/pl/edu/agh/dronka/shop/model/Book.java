package pl.edu.agh.dronka.shop.model;

public class Book extends Item {

    private int pages;

    private boolean hardcover;

    public Book(String name, Category category, int price, int quantity, int pages, boolean hardcover) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.pages = pages;
        this.hardcover = hardcover;
    }

    public Book() {
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setHardcover(boolean hardcover) {
        this.hardcover = hardcover;
    }

    public boolean isHardcover() {
        return hardcover;
    }
}
