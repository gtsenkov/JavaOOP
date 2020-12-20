package DesignPatternsLab.Singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonPopulationCounter implements SingletonContainer {
    private static SingletonPopulationCounter instance;
    private Map<String, Integer> populationMap;

    private SingletonPopulationCounter() {
        this.populationMap = new HashMap<>();
    }

    public static SingletonPopulationCounter getInstance() {
        //lazy loading
        if (instance != null) {
            return instance;
        }
        return instance = new SingletonPopulationCounter();
    }

    public void increasePopulation(String city, int increment) {
        this.populationMap.putIfAbsent(city, 0);
        this.populationMap.put(city, this.populationMap.get(city) + increment);
    }

    public void decreasePopulation(String city, int increment) {
        this.populationMap.put(city, this.populationMap.get(city) - increment);
    }

    @Override
    public int getPopulation(String city) {
        return this.populationMap.get(city);
    }
}
