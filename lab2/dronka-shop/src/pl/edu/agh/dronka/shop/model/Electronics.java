package pl.edu.agh.dronka.shop.model;

public class Electronics extends Item {

    private boolean mobile;

    private boolean warranty;

    public Electronics(String name, Category category, int price, int quantity, boolean mobile, boolean warranty) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.mobile = mobile;
        this.warranty = warranty;
    }
    public Electronics() {
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public boolean isMobile() {
        return mobile;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    public boolean isWarranty() {
        return warranty;
    }
}
