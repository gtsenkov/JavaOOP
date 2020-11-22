package WorkingWithAbstractionExr.GreedyTimes.WithSeparateClassesIsBetter;

public class Gem {
    private static long totalGems;
    private long quantity;
    private String gemName;

    public Gem(String gemName, long gemToAdd) {
        this.setQuantity(gemToAdd);
        this.gemName = gemName;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public static long getTotalGems() {
        return totalGems;
    }

    public static void setTotalGems(long totalGems) {
        Gem.totalGems = totalGems;
    }

    public long getQuantity() {
        return quantity;
    }

    public String getGemName() {
        return gemName;
    }
}
