package bakery.entities.drinks;

import bakery.entities.drinks.interfaces.Drink;

public class Water extends BaseDrink implements Drink {
    private static final double waterPrice   = 1.50;

    public Water(String name, int portion, String brand) {
        super(name, portion, waterPrice , brand);
    }
}
