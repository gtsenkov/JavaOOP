package DesignPatternsExr.FactoryPattern.model;

import DesignPatternsExr.FactoryPattern.shared.Factory;

public class StoneFactory implements Factory {
    @Override
    public GameObject produce() {
        return new Stone();
    }
}
