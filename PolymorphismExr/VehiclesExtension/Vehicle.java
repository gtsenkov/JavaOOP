package PolymorphismExr.VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    protected void driving(double distance, double fuelConsumption) {
        double fuelNeed = fuelConsumption * distance;
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
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        } else if (this.fuelQuantity + liters > this.tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        this.fuelQuantity += liters;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(),
                this.fuelQuantity);
    }
}
