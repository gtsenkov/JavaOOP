package bakery.entities.bakedFoods;

import bakery.entities.bakedFoods.interfaces.BakedFood;

public class Bread extends BaseFood implements BakedFood {
    private static final double InitialBreadPortion = 200.00;

    public Bread(String name, double price) {
        super(name, InitialBreadPortion, price);
    }
}
