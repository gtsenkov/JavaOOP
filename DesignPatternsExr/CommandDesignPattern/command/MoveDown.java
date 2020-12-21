package DesignPatternsExr.CommandDesignPattern.command;

import DesignPatternsExr.FactoryPattern.core.Main;

public class MoveDown implements Command {

    @Override
    public void execute() {
        Main.player.increaseRow();
    }
}
