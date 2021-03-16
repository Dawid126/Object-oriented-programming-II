package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Discount {

    private final BigDecimal value;

    public Discount(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
