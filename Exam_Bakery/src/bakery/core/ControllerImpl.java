package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static bakery.common.ExceptionMessages.TABLE_EXIST;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private List<Double> completedBills;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        this.completedBills = new ArrayList<>();
    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood foodByName = this.foodRepository.getByName(name);
        if (foodByName != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        BakedFood food = null;

        if (type.equals("Bread")) {
            food = new Bread(name, price);
        } else if (type.equals("Cake")) {
            food = new Cake(name, price);
        }

        if (food != null) {
            this.foodRepository.add(food);
        }

        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drinkByNameAndBrand = this.drinkRepository.getByNameAndBrand(name, brand);
        if (drinkByNameAndBrand != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        Drink drink = null;

        if (type.equals("Tea")) {
            drink = new Tea(name, portion, brand);
        } else if (type.equals("Water")) {
            drink = new Water(name, portion, brand);
        }

        if (drink != null) {
            this.drinkRepository.add(drink);
        }
        return String.format(DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table tableByNumber = this.tableRepository.getByNumber(tableNumber);
        if (tableByNumber != null) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }

        Table table = null;

        if (type.equals("InsideTable")) {
            table = new InsideTable(tableNumber, capacity);
        } else if (type.equals("OutsideTable")) {
            table = new OutsideTable(tableNumber, capacity);
        }

        if (table != null) {
            this.tableRepository.add(table);
        }
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Table table = this.tableRepository.getAll().stream()
                .filter(t -> t.isReserved() == false)
                .filter(t -> t.getCapacity() >= numberOfPeople)
                .findFirst().orElse(null);
        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        table.reserve(numberOfPeople);

        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table tableByNumber = this.tableRepository.getByNumber(tableNumber);
        if (tableByNumber == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        BakedFood foodByName = this.foodRepository.getByName(foodName);
        if (foodByName == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }

        tableByNumber.orderFood(foodByName);

        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table tableByNumber = this.tableRepository.getByNumber(tableNumber);
        if (tableByNumber == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        Drink drinkByNameAndBrand = this.drinkRepository.getByNameAndBrand(drinkName, drinkBrand);
        if (drinkByNameAndBrand == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }

        tableByNumber.orderDrink(drinkByNameAndBrand);

        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {
        Table tableByNumber = this.tableRepository.getByNumber(tableNumber);

        double bill = tableByNumber.getBill();
        tableByNumber.clear();

        this.completedBills.add(bill);

        return String.format("Table: %s%nBill: %.2f",
                tableByNumber.getTableNumber(), bill);

    }

    @Override
    public String getFreeTablesInfo() {
        List<Table> freeTables = this.tableRepository.getAll().stream()
                .filter(t -> t.isReserved() == false).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Table freeTable : freeTables) {
            sb.append(freeTable.getFreeTableInfo())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        Double sum = 0.0;

        for (Double completedBill : completedBills) {
            sum += completedBill;
        }

        return String.format("Total income: %.2flv" , sum);
    }
}
