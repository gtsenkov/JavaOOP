package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.CarRepository;
import easterRaces.repositories.DriverRepository;
import easterRaces.repositories.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.*;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.*;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> drivers;
    private Repository<Car> cars;
    private Repository<Race> races;

    public ControllerImpl(Repository<Driver> drivers, Repository<Car> cars, Repository<Race> races) {
        this.drivers = drivers;
        this.cars = cars;
        this.races = races;
    }

    @Override
    public String createDriver(String driver) {
        if (drivers.getAll().stream().anyMatch(d -> d.getName().equals(driver))) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }

        DriverImpl driver1 = new DriverImpl(driver);
        drivers.add(driver1);

        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;

        Car carByName = this.cars.getByName(model);
        if (carByName != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }

        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        } else {
            return "";
        }
            cars.add(car);

        return String.format(CAR_CREATED, car.getClass().getSimpleName(), car.getModel());
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driverByName = drivers.getByName(driverName);
        if (driverByName == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
        Car carByName = cars.getByName(carModel);
        if (carByName == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        driverByName.addCar(carByName);

        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race raceByName = races.getByName(raceName);
        if (raceByName == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        Driver driverByName = drivers.getByName(driverName);
        if (driverByName == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        raceByName.addDriver(driverByName);

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race raceByName = this.races.getByName(raceName);
        if (raceByName == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        int minParticipants = 3;
        if (this.drivers.getAll().size() < minParticipants) {
            throw new IllegalArgumentException(String.format(RACE_INVALID,
                    raceName, minParticipants));
        }

        this.races.remove(raceByName);

        Collection<Driver> allDrivers = this.drivers.getAll();
        Map<Driver, Double> driverPoints = new HashMap<>();
        for (Driver driver : allDrivers) {
            driverPoints.put(driver, driver.getCar().calculateRacePoints(raceByName.getLaps()));
        }

        List<Driver> top3drivers = driverPoints.entrySet()
                .stream().sorted((d1, d2) -> Double.compare(d2.getValue(), d1.getValue()))
                .limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

        top3drivers.get(0).winRace();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(DRIVER_FIRST_POSITION, top3drivers.get(0).getName(), raceName))
                .append(System.lineSeparator())
                .append(String.format(DRIVER_SECOND_POSITION, top3drivers.get(1).getName(), raceName))
                .append(System.lineSeparator())
                .append(String.format(DRIVER_THIRD_POSITION, top3drivers.get(2).getName(), raceName));

        return sb.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race raceByName = races.getByName(name);
        if (raceByName != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }

        Race race = new RaceImpl(name, laps);

        races.add(race);

        return String.format(RACE_CREATED, name);
    }
}
