package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.math.BigDecimal;
import java.util.LinkedList;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ProductNameSearchStrategyTest {
    private Product product1;
    private Product product2;
    private LinkedList<Product> products1;
    private LinkedList<Product> products2;
    private Order order1;
    private Order order2;

    private  void initTestComponents()
    {
        String productName1 = "Marchewka";
        String productName2 = "Baklazan";
        product1 = mock(Product.class);
        product2 = mock(Product.class);
        given(product1.getName()).willReturn(productName1);
        given(product2.getName()).willReturn(productName2);
        products1 = new LinkedList<>();
        products1.add(product1);
        products2 = new LinkedList<>();
        products2.add(product2);

        order1 = new Order(products1);
        order2 = new Order(products2);
    }

    @Test
    public void testProductNameSearchStrategyFilterWhenOrderMeetsSearchStrategy() {
        // given
        initTestComponents();
        SearchStrategy productNameSearchStrategy = new ProductNameSearchStrategy("Marchewka");
        // when
        boolean containsGivenOrder = productNameSearchStrategy.filter(order1);
        //then
        assertTrue(containsGivenOrder);
    }

    @Test
    public void testProductNameSearchStrategyFilterWhenOrdeDoesntrMeetsSearchStrategy() {
        // given
        initTestComponents();
        SearchStrategy productNameSearchStrategy = new ProductNameSearchStrategy("Marchewka");
        // when
        boolean containsGivenOrder = productNameSearchStrategy.filter(order2);
        //then
        assertFalse(containsGivenOrder);
    }
}
