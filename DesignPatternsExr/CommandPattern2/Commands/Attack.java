package DesignPatternsExr.CommandPattern2.Commands;

public class Attack implements Command {
    private Integer value;

    @Override
    public String execute() {
        return "Target defeated";
    }

    @Override
    public void setCommandValue(Integer value) {
        this.value = value;
    }


}
