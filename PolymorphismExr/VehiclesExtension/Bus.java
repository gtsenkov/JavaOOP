package PolymorphismExr.VehiclesExtension;

public class Bus extends Vehicle {
    public static final double AIR_CONDITIONER_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_CONSUMPTION, tankCapacity);
    }

}
