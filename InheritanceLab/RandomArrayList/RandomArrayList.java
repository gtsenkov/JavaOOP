package InheritanceLab.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    private Random random;

    public T getRandomElement() {
        this.random = new Random();
        int index = this.random.nextInt(super.size());

        return super.remove(index);
    }


}
