package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CompositeSearchStrategyTest {

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
        BigDecimal productPrice1 = BigDecimal.valueOf(5);
        BigDecimal productPrice2 = BigDecimal.valueOf(10);
        product1 = mock(Product.class);
        product2 = mock(Product.class);
        given(product1.getName()).willReturn(productName1);
        given(product2.getName()).willReturn(productName2);
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
    public void testOrderValueSearchStrategyFilterReturnsTrue() {
        // given
        initTestComponents();

        ArrayList<SearchStrategy> searchStrategies = new ArrayList<>();
        SearchStrategy productNameSearchStrategy = new ProductNameSearchStrategy("Marchewka");
        SearchStrategy orderValueSearchStrategy = new OrderValueSearchStrategy(BigDecimal.valueOf(5));

        searchStrategies.add(productNameSearchStrategy);
        searchStrategies.add(orderValueSearchStrategy);

        SearchStrategy compositeSearchStrategy = new CompositeSearchStrategy(searchStrategies);
        // when
        boolean containsGivenOrder = compositeSearchStrategy.filter(order1);
        //then
        assertTrue(containsGivenOrder);
    }

    @Test
    public void testOrderValueSearchStrategyFilterReturnsFalse() {
        // given
        initTestComponents();

        ArrayList<SearchStrategy> searchStrategies = new ArrayList<>();
        SearchStrategy productNameSearchStrategy = new ProductNameSearchStrategy("Marchewka");
        SearchStrategy orderValueSearchStrategy = new OrderValueSearchStrategy(BigDecimal.valueOf(5));

        searchStrategies.add(productNameSearchStrategy);
        searchStrategies.add(orderValueSearchStrategy);

        SearchStrategy compositeSearchStrategy = new CompositeSearchStrategy(searchStrategies);
        // when
        boolean containsGivenOrder = compositeSearchStrategy.filter(order2);
        //then
        assertFalse(containsGivenOrder);
    }

    @Test
    public void testOrderValueSearchStrategyFilterEmptyArray() {
        // given
        initTestComponents();

        ArrayList<SearchStrategy> searchStrategies = new ArrayList<>();

        SearchStrategy compositeSearchStrategy = new CompositeSearchStrategy(searchStrategies);
        // when
        boolean containsGivenOrder = compositeSearchStrategy.filter(order2);
        //then
        assertTrue(containsGivenOrder);
    }
}
