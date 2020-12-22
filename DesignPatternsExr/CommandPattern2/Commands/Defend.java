package DesignPatternsExr.CommandPattern2.Commands;

public class Defend implements Command {
    @Override
    public String execute() {
        return "Defeat activated";
    }

    @Override
    public void setCommandValue(Integer value) {
        throw new UnsupportedOperationException();
    }
}
