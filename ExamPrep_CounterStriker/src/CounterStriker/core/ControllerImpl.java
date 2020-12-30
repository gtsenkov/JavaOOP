package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {
    private GunRepository<Gun> guns;
    private PlayerRepository<Player> players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository<>();
        this.players = new PlayerRepository<>();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;
        if (type.equals("Pistol")) {
            gun = new Pistol(name, bulletsCount);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name, bulletsCount);
        } else {
            throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        guns.add(gun);
        return String.format(SUCCESSFULLY_ADDED_GUN, gun.getName());
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        if (guns.findByName(gunName) == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }
        Gun gunByName = guns.findByName(gunName);
        Player player;
        if (type.equals("Terrorist")) {
            player = new Terrorist(username, health, armor, gunByName);
        } else if (type.equals("CounterTerrorist")) {
            player = new CounterTerrorist(username, health, armor, gunByName);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        this.players.add(player);

        return String.format(SUCCESSFULLY_ADDED_PLAYER, player.getUsername());
    }

    @Override
    public String startGame() {
        Collection<Player> players = this.players.getModels().stream()
                .filter(Player::isAlive).collect(Collectors.toList());
        return this.field.start(players);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        this.players.getModels().stream().sorted((p1, p2) -> {
            int result = p1.getClass().getSimpleName().compareTo(p2.getClass().getSimpleName());
            if (result == 0) {
                result = Integer.compare(p2.getHealth(), p1.getHealth());
            }
            if (result == 0) {
                result = p1.getUsername().compareTo(p2.getUsername());
            }
            return result;
        })
                .forEach(p -> sb.append(p.toString())
                .append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
