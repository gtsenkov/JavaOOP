package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.List;

public class GarageTests {
    private List<Car> cars;
    private Garage garage;
    private Car car;

    @Before
    public void setUp() {
        garage = new Garage();
        car = new Car("Test_Brand", 260, 5000.00);
    }

    @Test
    public void testGetCars() {
        this.garage.addCar(car);
        Assert.assertEquals(this.car, this.garage.getCars().get(0));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCarsReturnUnmodifiable() {
        this.garage.addCar(car);
        List<Car> cars = this.garage.getCars();
        Car expectedCar = cars.remove(0);
    }

    @Test
    public void testGetCount() {
        this.garage.addCar(car);
        Assert.assertEquals(1, this.garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarThrowE() {
        this.garage.addCar(null);
    }

    @Test
    public void testAddCarWorks() {
        this.garage.addCar(car);
        Assert.assertEquals(1, this.garage.getCars().size());
    }

    @Test
    public void testGetTheMostExpensiveCar() {
        Car expensiveCar = new Car("Mercedes", 300, 50000.00);
        this.garage.addCar(expensiveCar);

        Car expectedTheMostExpensiveCar = this.garage.getTheMostExpensiveCar();

        Assert.assertEquals(expensiveCar, expectedTheMostExpensiveCar);
    }

    @Test
    public void testFindAllCarsByBrand() {
        Car expensiveCar = new Car("Mercedes", 300, 50000.00);
        Car expensiveCar1 = new Car("Mercedes", 330, 500000.00);
        this.garage.addCar(expensiveCar);
        this.garage.addCar(expensiveCar1);

        List<Car> mercedesBrand = this.garage.findAllCarsByBrand("Mercedes");

        Assert.assertEquals(2, mercedesBrand.size());

    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        Car expensiveCar = new Car("Mercedes", 320, 50000.00);
        Car expensiveCar1 = new Car("Mercedes", 330, 500000.00);
        this.garage.addCar(expensiveCar);
        this.garage.addCar(expensiveCar1);
        this.garage.addCar(car);

        List<Car> expectedCarsWithMaxSpeedAbove = this.garage.findAllCarsWithMaxSpeedAbove(300);

        Assert.assertEquals(2, expectedCarsWithMaxSpeedAbove.size());
    }
}