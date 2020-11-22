package WorkingWithAbstractionExr.GreedyTimes.WithSeparateClassesIsBetter;

public class Gold {
    private long quantity;
    public static long totalGold;

    private Gold() {
     //this will prevent somebody to create object of this Class
    }


    public static void setTotalGold(long totalGold) {
        Gold.totalGold = totalGold;
    }

    public static long getTotalGold() {
        return totalGold;
    }
}
