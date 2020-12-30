package CounterStriker.models.guns;

public class Rifle extends GunImpl implements Gun {
    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    //TODO not sure if Gun Should be implemented?????


    @Override
    public int fire() {
        if (this.getBulletsCount() == 0) {
            return 0;
        }
        this.setBulletsCount(this.getBulletsCount() - 10);
        return 10;
    }

    // can fire 10 bullets
}
