package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        setUsername(username);
        setHealth(health);
        setArmor(armor);
        setGun(gun);
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
        if (health > 0) {
            this.isAlive = true;
        }
    }

    public void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    public void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        int resultPoints = this.getArmor() - points;
        if (resultPoints < 0) {
            this.setArmor(0);
            int resultHealth = this.getHealth() - Math.abs(resultPoints);
            if (resultHealth <= 0) {
                isAlive = false;
                this.setHealth(0);
            } else {
                this.setHealth(resultHealth);
            }
        } else {
            setArmor(resultPoints);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.getUsername()
                + System.lineSeparator()
                + "--Health: " + this.getHealth()
                + System.lineSeparator()
                + "--Armor: " + this.getArmor()
                + System.lineSeparator()
                + "--Gun: " + this.getGun().getName();
    }
}
