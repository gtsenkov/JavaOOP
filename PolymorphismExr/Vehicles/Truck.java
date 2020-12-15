package PolymorphismExr.Vehicles;

public class Truck extends Vehicle{
    private static final double AIR_CONDITIONER_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AIR_CONDITIONER_CONSUMPTION);
    }

    @Override
    protected void refueling(double liters) {
        super.refueling(liters * 0.95);
    }
}
