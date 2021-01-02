package halfLife;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTests {
    private Gun gun;
    private Player player;
    private ArrayList<Gun> guns;

    @Before
    public void SetUp() {
        this.player = new Player("Test", 50);
        this.gun = new Gun("Test_Gun", 5);
        this.guns = new ArrayList<>();
    }

    @Test
    public void testCreatedInstance() {
        Assert.assertNotNull(player);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUserNameNull() {
        this.player = new Player(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUserNameEmpty() {
        this.player = new Player(" ", 5);
        String username = player.getUsername();
    }

    @Test
    public void testGetUserName() {
        String username = player.getUsername();
        Assert.assertEquals("Test", username);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthIncorrect() {
        this.player = new Player("Gosho", -5);
    }

    @Test
    public void testGetHealthCorrectly() {
        int expectedHealth = this.player.getHealth();
        Assert.assertEquals(50, expectedHealth);
    }

    @Test(expected = NullPointerException.class)
    public void testAddEmptyGun() {
        this.player.addGun(null);
    }

    @Test
    public void testAddGunCorrect() {
        this.player.addGun(gun);
        Assert.assertEquals(1, player.getGuns().size());
        Assert.assertEquals(this.gun, player.getGun(this.gun.getName()));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetGunsAsUnmodifiable() {
        this.guns.add(this.gun);
        List<Gun> guns = this.player.getGuns();
        guns.remove(0);
    }

    @Test
    public void testGetGunsCorrect() {
        List<Gun> expectedGuns = this.player.getGuns();
        Assert.assertEquals(expectedGuns.size(), 0);
    }

    @Test
    public void testTakeDamageCorrect() {
        this.player.takeDamage(10);
        Assert.assertEquals(40, this.player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageOfDead() {
        this.player = new Player("Toshko", 0);
        this.player.takeDamage(10);
    }

    @Test
    public void testTakeBiggerDamage() {
        this.player = new Player("Toshko", 10);
        this.player.takeDamage(100);
        Assert.assertEquals(0, player.getHealth());
    }

    @Test
    public void testRemoveGun() {
        //adds gun from player instance not directly from guns,
        // otherwise test does not pass in Judge
        player.addGun(this.gun);
        boolean removeGun = this.player.removeGun(this.gun);
        Assert.assertTrue(removeGun);
        Assert.assertEquals(0, player.getGuns().size());
    }

    @Test
    public void testGetGun() {
        this.player.addGun(this.gun);
        Gun expectedGun = this.player.getGun("Test_Gun");
        Assert.assertEquals(expectedGun, this.gun);
    }




}
