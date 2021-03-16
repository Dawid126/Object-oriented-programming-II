package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
	
	public static final int PRICE_PRECISION = 2;
	public static final RoundingMode ROUND_STRATEGY = RoundingMode.HALF_UP;
	
    private final String name;
    private final BigDecimal price;
    private Discount productDiscount;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price.setScale(PRICE_PRECISION, ROUND_STRATEGY);
        this.productDiscount = new Discount(BigDecimal.valueOf(0));
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPriceWithDiscount() {
        return price.multiply(BigDecimal.ONE.subtract(productDiscount.getValue())).setScale(PRICE_PRECISION, ROUND_STRATEGY);
    }

    public Discount getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(Discount productDiscount) {
        this.productDiscount = productDiscount;
    }
}
