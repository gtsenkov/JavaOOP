package DesignPatternsExr.CommandPattern2.Commands;

public interface Command {
    String execute();

    void setCommandValue(Integer value);
}
