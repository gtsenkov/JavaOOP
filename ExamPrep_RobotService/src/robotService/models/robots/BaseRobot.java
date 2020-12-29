package robotService.models.robots;


import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.INVALID_ENERGY;
import static robotService.common.ExceptionMessages.INVALID_HAPPINESS;

public abstract class BaseRobot implements Robot {
    private final static String DEFAULT_OWNER = "Service";
    private String name;
    private int happiness;
    private int energy;
    private int procedureTime;
    private String owner;
    private boolean isBought;
    private boolean isRepaired;
    private String robotType;

    protected BaseRobot(String name, int energy, int happiness, int procedureTime) {
        this.name = name;
        this.setHappiness(happiness);
        this.setEnergy(energy);
        this.procedureTime = procedureTime;
        this.owner = DEFAULT_OWNER;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public int getHappiness() {
        return this.happiness;
    }

    @Override
    public int getProcedureTime() {
        return this.procedureTime;
    }

    @Override
    public void setBought(boolean bought) {
        isBought = bought;
    }

    @Override
    public void setEnergy(int energy) {
        if (energy > 100 || energy < 0) {
            throw new IllegalArgumentException(INVALID_ENERGY);
        }
        this.energy = energy;
    }

    @Override
    public void setHappiness(int happiness) {
        if (happiness > 100 || happiness < 0) {
            throw new IllegalArgumentException(INVALID_HAPPINESS);
        }
        this.happiness = happiness;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public void setProcedureTime(int procedureTime) {
        this.procedureTime = procedureTime;
    }

    @Override
    public void setRepaired(boolean repaired) {
        this.isRepaired = repaired;
    }

    @Override
    public boolean isRepaired() {
        return false;
    }

    @Override
    public String toString() {

        return " Robot type: "
                + this.getClass().getSimpleName()
                + " - " + this.getName()
                + " - Happiness: " + this.getHappiness()
                + " - Energy: " + this.getEnergy();
    }

    public boolean isBought() {
        return false;
    }
}
