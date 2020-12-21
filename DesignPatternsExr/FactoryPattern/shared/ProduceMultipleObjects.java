package DesignPatternsExr.FactoryPattern.shared;

import DesignPatternsExr.FactoryPattern.model.GameObject;

import java.util.List;

public interface ProduceMultipleObjects {
    List<GameObject> produce();

    void setFactories(List<Factory> objectFactory);
}
