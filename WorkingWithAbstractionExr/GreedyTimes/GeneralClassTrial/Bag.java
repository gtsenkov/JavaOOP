package WorkingWithAbstractionExr.GreedyTimes.GeneralClassTrial;


import java.util.*;

public class Bag {

    private long capacity;
    private Map<String, List<Item>> consistency;
    private List<Item> items;
    private String mainType;


    public Bag(long capacity) {
        this.capacity = capacity;
        this.consistency = new LinkedHashMap<>();
        this.items = new ArrayList<>();

    }

    public boolean fillBag(String mainType) {
        this.mainType = mainType;

        if (this.mainType.length() == 3) {
            setMainType("Cash");
        } else if (this.mainType.toLowerCase().endsWith("gem")) {
            setMainType("Gem");
        } else if (this.mainType.toLowerCase().equals("gold")) {
            setMainType("Gold");
        }
        if (this.mainType.isBlank()) {
            return true;
        }

        if (!this.consistency.containsKey(getMainType())) {
            this.consistency.put(getMainType(), this.items = new ArrayList<>());
        }

//        if (this.consistency.get(getMainType()).isEmpty()) {
//            this.consistency.put(getMainType(), this.items = new ArrayList<>());
//        } else {
//            if (!this.consistency.containsKey(getMainType())) {
//                this.consistency.put(getMainType(), this.items);
//            }
//        }
        return false;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public String getMainType() {
        return mainType;
    }

    public long getCapacity() {
        return capacity;
    }

    public Map<String, List<Item>> getConsistency() {
        return consistency;
    }

    public void setConsistency(Map<String, List<Item>> consistency) {
        this.consistency = consistency;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    //diagram --> Bag is Map<Gem, List<Gems, Cash, Gold>
    // item -> Gems = List<Map<subType, quantity>>
    // item -> Cash = List<Map<subType, quantity>>
    // item -> Gold = quantity

}

