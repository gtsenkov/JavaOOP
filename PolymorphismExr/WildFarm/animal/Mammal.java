package PolymorphismExr.WildFarm.animal;

import PolymorphismExr.WildFarm.food.Food;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{

    private String livingRegion;

    public Mammal(String animalType, String animalName, Double animalWeight,
                  String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]", this.getAnimalName(),
                this.getAnimalType(), formatter.format(this.getAnimalWeight())
                ,this.livingRegion, this.getFoodEaten());
    }
}
