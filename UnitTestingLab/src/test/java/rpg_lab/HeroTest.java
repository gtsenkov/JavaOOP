package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class HeroTest {

//    @Test
//    public void testHeroGainXpByKillingTargets() {
//
//        Weapon weapon = mock(Weapon.class);
//
//
//        Hero hero = new Hero("Test_Hero", weapon);
//
//        Target target = mock(Target.class);
//
//        when(target.isDead()).thenReturn(true);
//        when(target.giveExperience()).thenReturn(10);
//
//        hero.attack(target);
//
//        assertEquals(10, hero.getExperience());
//    }

    @Test
    public void testItemDropShouldDropCorrectly() {
        Weapon weapon = mock(Weapon.class);

        Hero hero = new Hero("Test_Hero", weapon);

        Target target = mock(Target.class);

        when(target.isDead()).thenReturn(true);

        Random random = mock(Random.class);

        Weapon weapon3 = mock(Weapon.class);

        when(weapon3.getAttack()).thenReturn(73);

        when(target.dropWeapon(random)).thenReturn(weapon3);

        Weapon wep = hero.attack(target, random);

        assertEquals(73, wep.getAttack());
    }

}