package DesignPatternsExr.FactoryPattern;

import DesignPatternsExr.FactoryPattern.data.DataStorage;
import DesignPatternsExr.FactoryPattern.model.GameObject;
import DesignPatternsExr.FactoryPattern.shared.*;

import java.util.ArrayList;
import java.util.List;

public class Initializer {
    public static DataStorage dataStorage = new DataStorage();
    public static ProduceMultipleObjects multiple = new InitialGameObject();
    public static List<Factory> objectFactory = new ArrayList<>();

    public static List<GameObject> init() {
        objectFactory.add(new PlayerFactory());
        objectFactory.add(new EnemyFactory());
        multiple.setFactories(objectFactory);
        return multiple.produce();
    }
}
