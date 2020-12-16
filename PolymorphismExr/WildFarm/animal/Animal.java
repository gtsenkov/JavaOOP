package PolymorphismExr.WildFarm.animal;

import PolymorphismExr.WildFarm.food.Food;

public abstract class Animal {
    private String animalType;
    private String animalName;
    private Double animalWeight;
    private Integer foodEaten;


    public Animal(String animalType, String animalName, Double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);

    public void eatable(Food food) {
        this.foodEaten += food.getQuantity();
    }

    public String getAnimalType() {
        return this.animalType;
    }

    public String getAnimalName() {
        return this.animalName;
    }

    public Double getAnimalWeight() {
        return this.animalWeight;
    }

    public Integer getFoodEaten() {
        return this.foodEaten;
    }
}
