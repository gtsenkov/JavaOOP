package bakery.entities.tables;

import bakery.entities.tables.interfaces.Table;

public class OutsideTable extends BaseTable implements Table {
    private static final double pricePerPerson = 3.50;

    public OutsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, pricePerPerson);
    }
}
