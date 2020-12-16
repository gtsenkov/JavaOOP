package PolymorphismExr.WildFarm.animal;

import PolymorphismExr.WildFarm.food.Food;

public class Tiger extends Mammal{


    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        } else {
            eatable(food);
        }
    }
}
