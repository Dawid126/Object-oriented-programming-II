package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

public class OrderHistoryDatabaseTest {

    private Order getOrderWithMockedProduct() {
        Product product = mock(Product.class);
        LinkedList<Product> products = new LinkedList<>();
        products.add(product);
        return new Order(products);
    }

    @Test
    public void testEmptyOrderHistoryDatabase() {
        // given
        OrderHistoryDatabase database = new OrderHistoryDatabase();

        // when
        boolean hasNext = database.iterator().hasNext();

        // then
        assertEquals(hasNext, false);
    }

    @Test
    public void testGetOrderFromDatabase() {
        // given
        OrderHistoryDatabase database = new OrderHistoryDatabase();
        Order expectedOrder = getOrderWithMockedProduct();

        // when
        database.addOrder(expectedOrder);

        // then
        assertSame(expectedOrder, database.iterator().next());
    }

    @Test
    public void testGetOrderFromDatabaseWithSearchStrategy() {
        // given
        OrderHistoryDatabase database = new OrderHistoryDatabase();
        Product expectedProduct1 = new Product("Marchewka", BigDecimal.valueOf(5));
        LinkedList<Product> products1 = new LinkedList<>();
        products1.add(expectedProduct1);

        Product expectedProduct2 = new Product("Baklazan", BigDecimal.valueOf(5));
        LinkedList<Product> products2 = new LinkedList<>();
        products2.add(expectedProduct2);

        Order expectedOrder1 = new Order(products1);
        Order expectedOrder2 = new Order(products2);
        SearchStrategy searchStrategy = new ProductNameSearchStrategy(expectedProduct1.getName());

        // when
        database.addOrder(expectedOrder1);
        database.addOrder(expectedOrder2);

        // then
        assertSame(expectedOrder1, database.iterator(searchStrategy).next());
    }
}
