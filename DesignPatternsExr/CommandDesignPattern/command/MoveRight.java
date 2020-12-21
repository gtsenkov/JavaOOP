package DesignPatternsExr.CommandDesignPattern.command;

import static DesignPatternsExr.FactoryPattern.core.Main.player;

public class MoveRight implements Command {

    @Override
    public void execute() {
        player.increaseCol();
    }
}
