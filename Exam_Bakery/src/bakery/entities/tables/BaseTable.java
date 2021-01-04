package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) { //todo with = or not?
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        this.price = this.pricePerPerson * numberOfPeople;
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.isReserved = true;
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double totalPriceFood = this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum();
        double totalPriceDrink = this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum();
        double pricePerConsuption = totalPriceFood + totalPriceDrink;
        double pricePerPeople = this.getPrice();
        double finalPrice = pricePerPeople + pricePerConsuption;
        return finalPrice;
    }

    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear(); //todo check if it works
        this.numberOfPeople = 0;
        this.price = 0;
        this.isReserved = false; //todo check if this is needed
    }

    @Override
    public String getFreeTableInfo() {
        String output = "Table: " + this.getTableNumber() +
                System.lineSeparator() +
        "Type: " + this.getClass().getSimpleName() +
                System.lineSeparator() +
        "Capacity: " + this.getCapacity() +
                System.lineSeparator() +
        "Price per Person: ";
        if (this.getClass().getSimpleName().equals("InsideTable")) {
            output += "2.50";
        } else {
            output += "3.50";
        }
        return output;
    }
}
