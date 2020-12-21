package DesignPatternsExr.CommandDesignPattern.command;

import static DesignPatternsExr.FactoryPattern.core.Main.player;

public class MoveLeft implements Command {

    @Override
    public void execute() {
        player.decreaseCol();
    }
}
