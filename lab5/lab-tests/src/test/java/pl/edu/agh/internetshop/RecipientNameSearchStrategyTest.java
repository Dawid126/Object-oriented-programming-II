package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class RecipientNameSearchStrategyTest {
    private Product product1;
    private LinkedList<Product> products1;
    private Address address1;
    private Shipment shipment1;
    private Order order1;

    private  void initTestComponents()
    {
        String recipientName1 = "Franek";
        String recipientName2 = "Staszek";
        product1 = mock(Product.class);
        address1 = mock(Address.class);
        shipment1 = mock(Shipment.class);
        given(address1.getName()).willReturn(recipientName1);
        given(shipment1.getRecipientAddress()).willReturn(address1);
        products1 = new LinkedList<>();
        products1.add(product1);

        order1 = new Order(products1);
        order1.setShipment(shipment1);
    }

    @Test
    public void testRecipientNameSearchStrategyFilterWhenOrderMeetsSearchStrategy() {
        // given
        initTestComponents();
        SearchStrategy recipientNameSearchStrategy = new RecipientNameSearchStrategy("Franek");
        // when
        boolean containsGivenOrder = recipientNameSearchStrategy.filter(order1);
        //then
        assertTrue(containsGivenOrder);
    }

    @Test
    public void testRecipientNameSearchStrategyFilterWhenOrderDoesntMeetsSearchStrategy() {
        // given
        initTestComponents();
        SearchStrategy recipientNameSearchStrategy = new RecipientNameSearchStrategy("Staszek");
        // when
        boolean containsGivenOrder = recipientNameSearchStrategy.filter(order1);
        //then
        assertFalse(containsGivenOrder);
    }
}
