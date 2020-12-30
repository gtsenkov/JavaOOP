package CounterStriker.models.guns;

public class Pistol extends GunImpl implements Gun {
    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    //TODO not sure if Gun Should be implemented?????


    @Override
    public int fire() {
        if (this.getBulletsCount() == 0) {
            return 0;
        }
        this.setBulletsCount(this.getBulletsCount() - 1);
        return 1;
    }

    // can fire 1 bullet

}
