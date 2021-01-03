package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Map;

public class BankVaultTest {

private Item item;
private BankVault bankVault;

    @Before
    public void SetUp() {
        this.item = new Item("Test_Owner", "ID");
        this.bankVault = new BankVault();
    }

    @Test
    public void testGetter() {
        Assert.assertNotNull(this.bankVault.getVaultCells());
    }

    @Test
    public void testConstructor() {
        Item c4 = this.bankVault.getVaultCells().get("C4");
        Assert.assertNull(c4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testTestGetterReturnsUnmod() {
        Map<String, Item> vaultCells = this.bankVault.getVaultCells();
        vaultCells.remove(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDoesNotExist() throws OperationNotSupportedException {
        this.bankVault.addItem("d", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToTakenCell() throws OperationNotSupportedException {
        Item testItem = new Item("Test_Owner1", "ID1");
        this.bankVault.addItem("C4", testItem);
        this.bankVault.addItem("C4", this.item);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddToSameItem() throws OperationNotSupportedException {
        Item testItem = new Item("Test_Owner1", "ID1");
        this.bankVault.addItem("C4", this.item);
        this.bankVault.addItem("B1", this.item);
    }

    @Test
    public void testAddCorrectly() throws OperationNotSupportedException {
        this.bankVault.addItem("C4", this.item);
        Item C4itemExistance = this.bankVault.getVaultCells().get("C4");
        Assert.assertNotNull(C4itemExistance);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveOfDoesNotExist() {
        this.bankVault.removeItem("4", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExisting() throws OperationNotSupportedException {
        this.bankVault.addItem("C4", this.item);
        this.bankVault.removeItem("C4", null);
    }

    @Test
    public void testRemovesCOrrectly() throws OperationNotSupportedException {
        this.bankVault.addItem("C4", this.item);
        this.bankVault.removeItem("C4", this.item);

        Item itemC4 = this.bankVault.getVaultCells().get("C4");

        Assert.assertNull(itemC4);
    }


    //asserboolean maybe "itemExist"



}