package DesignPatternsExr.CommandDesignPattern.command;

import DesignPatternsExr.FactoryPattern.core.Main;
import DesignPatternsExr.FactoryPattern.model.StoneFactory;
import DesignPatternsExr.FactoryPattern.shared.Factory;

public class Fire implements Command {

    @Override
    public void execute() {
        Main.player.throwStone();
    }
}
