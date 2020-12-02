package InheritanceExr.Restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish {
    private static final double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price, double calories) {
        super(name, price, SALMON_GRAMS, calories);
    }
}
