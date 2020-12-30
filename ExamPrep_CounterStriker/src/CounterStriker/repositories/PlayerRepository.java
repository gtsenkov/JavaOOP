package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;

public class PlayerRepository<T extends Player> implements Repository<T>{

    private List<T> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getModels() {
        return this.models;
    }

    @Override
    public void add(T model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        this.models.add((model));
    }

    @Override
    public boolean remove(T model) {
        if (this.models.remove(model)) {
            return true;
        }
        return false;
    }

    @Override
    public T findByName(String name) {
        return this.models.stream()
                .filter(g -> g.getUsername().equals(name))
                .findFirst().orElse(null);
    }
}
