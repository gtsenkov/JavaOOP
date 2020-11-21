package WorkingWithAbstractionExr.CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (CardRank suit : CardRank.values()) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    suit.ordinal(), suit));
            
        }
    }
}
