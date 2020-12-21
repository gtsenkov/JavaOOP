package DesignPatternsExr.FactoryPattern.shared;

import DesignPatternsExr.FactoryPattern.core.Field;
import DesignPatternsExr.FactoryPattern.model.GameObject;

import java.util.ArrayList;
import java.util.List;

public class InitialGameObject implements ProduceMultipleObjects {
    private List<Factory> objectFactories;

    public InitialGameObject() {
        this.objectFactories = new ArrayList<>();
    }

    @Override
    public List<GameObject> produce() {

        List<GameObject> gameObjects = new ArrayList<>();
        for (Factory objectFactory : objectFactories) {
            gameObjects.add(objectFactory.produce());
        }

        gameObjects.add(new Field());

        return gameObjects;
    }

    @Override
    public void setFactories(List<Factory> objectFactories) {
        this.objectFactories = objectFactories;
    }
}
