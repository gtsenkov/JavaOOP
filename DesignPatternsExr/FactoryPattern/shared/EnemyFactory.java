package DesignPatternsExr.FactoryPattern.shared;

import DesignPatternsExr.FactoryPattern.Initializer;
import DesignPatternsExr.FactoryPattern.model.Enemy;
import DesignPatternsExr.FactoryPattern.model.GameObject;
import DesignPatternsExr.FactoryPattern.model.Player;

public class EnemyFactory implements Factory {
    @Override
    public GameObject produce() {
        int[] params = Initializer.dataStorage.load(Enemy.class);
        return new Enemy(params[0], params[1]);
    }
}
