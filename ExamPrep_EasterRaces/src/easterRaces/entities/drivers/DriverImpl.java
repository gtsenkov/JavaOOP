package easterRaces.entities.drivers;

import easterRaces.entities.cars.Car;

import static easterRaces.common.ExceptionMessages.*;

public class DriverImpl implements Driver {
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        this.setName(name);
    }

    public void setName(String name) {
        int minimumLetters = 5;
        if (name == null || name.trim().isEmpty() || name.length() < minimumLetters) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, minimumLetters));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            this.canParticipate = false; //if car is not null then it is true
            throw new IllegalArgumentException(CAR_INVALID);
        }
        this.canParticipate = true;
        this.car = car;
    }

    @Override
    public void winRace() {
        this.numberOfWins += 1;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }
}
