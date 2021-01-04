package bakery.entities.bakedFoods;

import bakery.entities.bakedFoods.interfaces.BakedFood;

public class Cake extends BaseFood implements BakedFood {
    private static final double InitialBreadPortion = 245.00;

    public Cake(String name, double price) {
        super(name, InitialBreadPortion, price);
    }
}
