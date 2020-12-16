package PolymorphismExr.WildFarm.animal;

import PolymorphismExr.WildFarm.food.Food;

public class Zebra extends Mammal{


    public Zebra(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        } else {
            eatable(food);
        }
    }
}
