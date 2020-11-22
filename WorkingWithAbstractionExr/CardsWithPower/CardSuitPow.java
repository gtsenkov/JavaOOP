package WorkingWithAbstractionExr.CardsWithPower;

public enum CardSuitPow {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    final private int power;

    CardSuitPow(int power) {
        this.power = power;
    }

    public int getSuitPower() {
        return power;
    }
}
