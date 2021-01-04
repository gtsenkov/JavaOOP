package bakery.entities.tables;

import bakery.entities.tables.interfaces.Table;

public class InsideTable extends BaseTable implements Table {
    private static final double pricePerPerson = 2.50;

    public InsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, pricePerPerson);
    }
}
