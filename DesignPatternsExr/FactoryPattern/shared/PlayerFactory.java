package DesignPatternsExr.FactoryPattern.shared;

import DesignPatternsExr.FactoryPattern.Initializer;
import DesignPatternsExr.FactoryPattern.model.GameObject;
import DesignPatternsExr.FactoryPattern.model.Player;

public class PlayerFactory implements Factory {
    public GameObject produce() {
        int[] params = Initializer.dataStorage.load(Player.class);
        return new Player(params[0], params[1]);
    }
}
