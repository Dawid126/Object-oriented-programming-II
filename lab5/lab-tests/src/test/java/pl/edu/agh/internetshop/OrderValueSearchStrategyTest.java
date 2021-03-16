package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class OrderValueSearchStrategyTest {
    private Product product1;
    private Product product2;
    private LinkedList<Product> products1;
    private LinkedList<Product> products2;
    private Order order1;
    private Order order2;

    private  void initTestComponents()
    {
        BigDecimal productPrice1 = BigDecimal.valueOf(5);
        BigDecimal productPrice2 = BigDecimal.valueOf(10);
        product1 = mock(Product.class);
        product2 = mock(Product.class);
        given(product1.getPrice()).willReturn(productPrice1);
        given(product2.getPrice()).willReturn(productPrice2);
        products1 = new LinkedList<>();
        products1.add(product1);
        products2 = new LinkedList<>();
        products2.add(product2);

        order1 = new Order(products1);
        order2 = new Order(products2);
    }

    @Test
    public void testOrderValueSearchStrategyFilterWhenOrderMeetsSearchStrategy() {
        // given
        initTestComponents();
        SearchStrategy orderValueSearchStrategy = new OrderValueSearchStrategy(BigDecimal.valueOf(5));
        // when
        boolean containsGivenOrder = orderValueSearchStrategy.filter(order1);
        //then
        assertTrue(containsGivenOrder);
    }

    @Test
    public void testOrderValueSearchStrategyFilterWhenOrderDoesntMeetSearchStrategy() {
        // given
        initTestComponents();
        SearchStrategy orderValueSearchStrategy = new OrderValueSearchStrategy(BigDecimal.valueOf(5));
        // when
        boolean containsGivenOrder = orderValueSearchStrategy.filter(order2);
        //then
        assertFalse(containsGivenOrder);
    }
}
