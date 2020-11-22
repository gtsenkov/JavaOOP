package WorkingWithAbstractionExr.GreedyTimes.GeneralClassTrial;

import java.util.*;

public class Item {


    private String mainType;
    private String subType;
    private Long subQuantity;
    private List<Map<String, Long>> subItem;
    private Map<String, Long> subTypeConsistency;
    private Map<String, Long> totalSubQuantity;
    private boolean canNotBeAdded;

    public Item(String subType, Long quantity) {
        this.subType = subType;
        this.mainType = subType;
        this.subTypeConsistency = new LinkedHashMap<>();
        this.totalSubQuantity = new LinkedHashMap<>();
        this.subItem = new ArrayList<>();

        if (this.mainType.length() == 3) {
            setMainType("Cash");
        } else if (this.mainType.toLowerCase().endsWith("gem")) {
            setMainType("Gem");
        } else if (this.mainType.toLowerCase().equals("gold")) {
            setMainType("Gold");
        }

        this.subQuantity = quantity;

        if (!getSubItem().isEmpty()) {
            if (!getSubTypeConsistency().isEmpty()) {
                switch (getMainType()) {
                    case "Gem":
                        if (!getSubTypeConsistency().containsKey(getMainType())) {
                            if (getSubTypeConsistency().containsKey("Gold")) {
                                if (getSubQuantity() > getSubTypeConsistency().get("Gold")) {
                                    setCanNotBeAdded();
                                }
                            } else {
                                setCanNotBeAdded();
                            }
                        } else if
                        (getTotalSubQuantity("Gem") + getSubQuantity() > getSubTypeConsistency().get("Gold")) {
                            setCanNotBeAdded();
                        }
                        break;
                    case "Cash":
                        if (!getSubTypeConsistency().containsKey(getMainType())) {
                            if (getSubTypeConsistency().containsKey("Gem")) {
                                if (getSubQuantity() > getTotalSubQuantity("Gem")) {
                                    setCanNotBeAdded();
                                }
                            } else {
                                setCanNotBeAdded();
                            }
                        } else if (getTotalSubQuantity("Cash") + getSubQuantity() > getTotalSubQuantity("Gem")) {
                            setCanNotBeAdded();
                        }
                        break;
                }
            }
        } else {

            if (!this.subTypeConsistency.containsKey(getMainType())) {
                this.subTypeConsistency.put(getMainType(), getSubQuantity());
                this.subItem.add(this.subTypeConsistency);
                if (totalSubQuantity.isEmpty()) {
                    this.totalSubQuantity.put(getMainType(), getSubQuantity());
                } else {
                    increaseTotalSubQuantity();
                }
            } else {
                this.subTypeConsistency.put(getMainType(),this.subTypeConsistency.get(getMainType()) + getSubQuantity());
                increaseTotalSubQuantity();
            }
        }

    }

    public boolean getCanNotBeAdded() {
        return this.canNotBeAdded;
    }

    public List<Map<String, Long>> getSubItem() {
        return subItem;
    }

    public String getMainType() {
        return mainType;
    }

    public Long getSubQuantity() {
        return subQuantity;
    }

    public Long getTotalSubQuantity(String key) {
        return this.totalSubQuantity.get(key);
    }

    public void increaseTotalSubQuantity() {
//        System.out.println(this.totalSubQuantity.get(getSubType()));
//        System.out.println(getSubQuantity());

        if (this.totalSubQuantity.get(getMainType()) == getSubQuantity()) {
            long increasedQuantity = totalSubQuantity.get(getMainType()) + getSubQuantity();
            this.totalSubQuantity.put(getMainType(), increasedQuantity);
        }
    }

    public long getAbsoluteTotalQuantity() {
       return this.totalSubQuantity.values().stream().mapToLong(e -> e).sum();
    }


    public void setCanNotBeAdded() {
        this.canNotBeAdded = true;
    }

    public Map<String, Long> getSubTypeConsistency() {
        return subTypeConsistency;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

}
