package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

public class CounterTerrorist extends PlayerImpl implements Player {
    public CounterTerrorist(String username, int health, int armor, Gun gun) {
        super(username, health, armor, gun);
    }

    //TODO not sure if Player interface Should be implemented?????

}
