package WorkingWithAbstractionLab.HotelReservation;

public class PriceCalculator {

    private Season season;
    private Discount discount;
    private double price;
    private int days;

    public PriceCalculator(Season season, Discount discount, double price, int days) {
        this.season = season;
        this.discount = discount;
        this.price = price;
        this.days = days;
    }

    public double calculatePrice() {
        return this.days * this.price * this.season.getMultiplier()
                * (1 - this.discount.getDiscount() / 100.00);
    }
}
