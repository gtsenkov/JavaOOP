package bakery.repositories;

import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DrinkRepositoryImpl<T extends Drink> implements DrinkRepository<T> {
    private Collection<T> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(T t) {
        this.models.add(t);
    }

    @Override
    public T getByNameAndBrand(String drinkName, String drinkBrand) {
        return this.models.stream()
                .filter(e -> e.getName().equals(drinkName))
                .filter(e -> e.getBrand().equals(drinkBrand))
                .findFirst().orElse(null);
    }


    public T getByName(String name) {
        return this.models.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
    }
}