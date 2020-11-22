package WorkingWithAbstractionExr.GreedyTimes.WithSeparateClassesIsBetter;


import java.util.ArrayList;
import java.util.List;

public class Bag {

    private long capacity;
   // private String itemToAdd;
    private Gold gold;
    private Gem gem;
    private Cash cash;
    private List<Gem> gems;
    private List<Cash> currencies;
    private long absoluteBagQuantity;
    private List<Object> consistency;



    public Bag(long capacity) {
        this.capacity = capacity;
        this.gems = new ArrayList<>();
        this.currencies = new ArrayList<>();
        this.consistency = new ArrayList<>();
        this.consistency.add(this.currencies);
        this.consistency.add(this.gems);

    }

    public void fillBag(String itemToAdd, long quantity) {
        this.absoluteBagQuantity = Gold.getTotalGold() + Cash.getTotalCash() + Gem.getTotalGems();
        long quantityWillBe = this.absoluteBagQuantity + quantity;
        if (quantityWillBe > this.getCapacity()) {
            return;
        }
        if (itemToAdd.length() == 3) {
            Cash cash = new Cash(itemToAdd, quantity);
            if (Cash.getTotalCash() + quantity > Gem.getTotalGems()) {
                return;
            }
            if (this.getCurrencies().contains(cash)) {
                this.cash.setQuantity(cash.getQuantity() + quantity);
            } else {
                this.currencies.add(cash);
            }
            Cash.setTotalCash(Cash.getTotalCash() + quantity);
        } else if (itemToAdd.toLowerCase().endsWith("gem")) {
            Gem gem = new Gem(itemToAdd, quantity);
            if (Gem.getTotalGems() + quantity > Gold.getTotalGold()) {
                return;
            }
            if (this.getGems().contains(gem)) {
                this.gem.setQuantity(gem.getQuantity() + quantity);
            } else {
                this.gems.add(gem);
            }
            Gem.setTotalGems(Gem.getTotalGems() + quantity);

        } else if (itemToAdd.toLowerCase().equals("gold")) {

            Gold.setTotalGold(Gold.getTotalGold() + quantity);
        }
    }


    public long getCapacity() {
        return capacity;
    }

    public List<Cash> getCurrencies() {
        return currencies;
    }

    public List<Gem> getGems() {
        return gems;
    }

}

