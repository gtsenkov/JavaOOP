package DesignPatternsExr.FactoryPattern.data;

import DesignPatternsExr.FactoryPattern.model.Enemy;
import DesignPatternsExr.FactoryPattern.model.Player;

import java.util.Map;

public class DataStorage {
    private Map<Class<?>, int[]> objectsData = Map.of(
            Player.class, new int[]{100, 24},
            Enemy.class, new int[]{240, 2}
    );

    public int[] load(Class<?> clazz) {
        return this.objectsData.get(clazz);
    }


}
