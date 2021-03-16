package pl.edu.agh.dronka.shop.model;

import java.util.Date;

public class Food extends Item {

    private Date expirationDate;

    public Food(String name, Category category, int price, int quantity, Date expirationDate) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }
    public Food() {
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
