package PolymorphismExr.Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }


    protected void driving(double distance) {
        double fuelNeed = this.fuelConsumption * distance;
        if (fuelNeed > fuelQuantity) {
            System.out.println(this.getClass().getSimpleName() + " needs refueling");
            return;
        }
        DecimalFormat formatter = new DecimalFormat("#.##");
        this.fuelQuantity -= fuelNeed;
        System.out.println(String.format("%s travelled %s km",
                this.getClass().getSimpleName(),
                formatter.format(distance)));
    }

    protected void refueling(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(),
                this.fuelQuantity);
    }
}
