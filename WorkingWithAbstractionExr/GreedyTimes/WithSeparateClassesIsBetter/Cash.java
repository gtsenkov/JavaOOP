package WorkingWithAbstractionExr.GreedyTimes.WithSeparateClassesIsBetter;

public class Cash {
    private static long totalCash;
    private long quantity;
    private String currencyType;

    public Cash(String currencyType, long cashToAdd) {
        this.setQuantity(cashToAdd);
        this.currencyType = currencyType;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public static long getTotalCash() {
        return totalCash;
    }

    public long getQuantity() {
        return quantity;
    }

    public static void setTotalCash(long totalCash) {
        Cash.totalCash = totalCash;
    }
}
