package DesignPatternsLab.Singleton;

public class Main {
    public static void main(String[] args) {
        SingletonPopulationCounter counter = SingletonPopulationCounter.getInstance();

        counter.increasePopulation("Sofia", 100);
        System.out.println(counter.getPopulation("Sofia"));

    }
}
