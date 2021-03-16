package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OrderValueSearchStrategy implements SearchStrategy {
    private BigDecimal orderValue;
    public static final int PRICE_PRECISION = 2;
    public static final RoundingMode ROUND_STRATEGY = RoundingMode.HALF_UP;

    public OrderValueSearchStrategy(BigDecimal orderValue) {
        this.orderValue = orderValue.setScale(PRICE_PRECISION, ROUND_STRATEGY);
    }

    public boolean filter(Order order) {
        return (orderValue.compareTo(order.getPrice()) == 0);
    }
}
