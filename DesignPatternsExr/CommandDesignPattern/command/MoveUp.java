package DesignPatternsExr.CommandDesignPattern.command;

import DesignPatternsExr.FactoryPattern.core.Main;

import static DesignPatternsExr.FactoryPattern.core.Main.player;

public class MoveUp implements Command {

    @Override
    public void execute() {
        player.decreaseRow();
    }
}
