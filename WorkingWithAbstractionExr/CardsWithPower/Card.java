package WorkingWithAbstractionExr.CardsWithPower;

public class Card {

    private CardRankPow numberPower;
    private CardSuitPow colorPower;
    private int powerTotal;


    public Card(CardRankPow numberPower, CardSuitPow colorPower) {
        this.numberPower = numberPower;
        this.colorPower = colorPower;
        this.powerTotal = numberPower.getRankPower() + colorPower.getSuitPower();
    }

    @Override
    public String toString() {
        String cardName = this.numberPower + " of " + this.colorPower;

        return String.format("Card name: %s; Card power: %d", cardName, this.powerTotal);
    }
}
