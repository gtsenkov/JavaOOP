package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 1000;
    private static final int DUMMY_EXPERIENCE = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
       // this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }


    @Test
    public void dummyLosesHealthWhenAttacked() {

        axe.attack(dummy);

        assertEquals(990, dummy.getHealth());
    }

    @Test(expected =  IllegalStateException.class)
    public void dummyThrowsExceptionWhenAttacked() {
     //   Dummy dummy = new Dummy(0, DUMMY_EXPERIENCE);

        dummy.takeAttack(AXE_ATTACK);
    }

    @Test
    public void dummyCanGiveXP() {
      //  Dummy dummy = new Dummy(0, DUMMY_EXPERIENCE);

        dummy.giveExperience();

        assertEquals(DUMMY_EXPERIENCE, dummy.giveExperience());
    }

    @Test(expected =  IllegalStateException.class)
    public void dummyCantGiveXP() {

        dummy.giveExperience();
    }

}