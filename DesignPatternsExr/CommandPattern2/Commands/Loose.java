package DesignPatternsExr.CommandPattern2.Commands;

import DesignPatternsExr.CommandPattern2.Main;

public class Loose implements Command {
    @Override
    public String execute() {
        Main.gameOver = true;
        return "You lost Game Over";
    }

    @Override
    public void setCommandValue(Integer value) {
        //can be segregated in other interface
    }
}
