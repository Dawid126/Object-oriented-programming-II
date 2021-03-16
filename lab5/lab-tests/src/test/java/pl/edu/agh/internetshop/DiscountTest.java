package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

public class DiscountTest {

    @Test
    public void testAddDiscountToProduct() {
        Discount discount = new Discount(BigDecimal.valueOf(0.15));
        Product product = new Product("Prod1", BigDecimal.valueOf(2));
        product.setProductDiscount(discount);
        assertEquals(product.getProductDiscount(), discount);
        assertEquals(product.getProductDiscount().getValue(), discount.getValue());
    }

    @Test
    public void testPriceOfProductWithDiscount() {
        Discount discount = new Discount(BigDecimal.valueOf(0.15));
        Product product = new Product("Prod1", BigDecimal.valueOf(100));
        product.setProductDiscount(discount);
        assertEquals(product.getPriceWithDiscount(), BigDecimal.valueOf(100).multiply(BigDecimal.valueOf(0.85)));
    }

    @Test
    public void testPriceOfOrderWithProductWithDiscount() {
        Discount discount = new Discount(BigDecimal.valueOf(0.15));
        Product product = new Product("Prod1", BigDecimal.valueOf(100));
        product.setProductDiscount(discount);
        LinkedList<Product> products = new LinkedList<>();
        products.add(product);
        Order order = new Order(products);
        assertEquals(order.getPriceWithDiscounts(), BigDecimal.valueOf(100).multiply(BigDecimal.valueOf(0.85)));
    }

    @Test
    public void testPriceOfOrderWithDiscountWithProductWithDiscount() {
        Discount discount = new Discount(BigDecimal.valueOf(0.15));
        Product product = new Product("Prod1", BigDecimal.valueOf(100));
        product.setProductDiscount(discount);
        LinkedList<Product> products = new LinkedList<>();
        products.add(product);
        Order order = new Order(products);
        order.setOrderDiscount(discount);
        assertEquals(order.getPriceWithDiscounts(), BigDecimal.valueOf(100).multiply(BigDecimal.valueOf(0.85)).multiply(BigDecimal.valueOf(0.85)).setScale(2));
    }
}
