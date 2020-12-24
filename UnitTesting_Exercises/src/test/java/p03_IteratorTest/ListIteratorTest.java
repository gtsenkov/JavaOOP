package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] DATA = {"X", "Y", "Z"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(DATA);
    }

    //Constructor
    //1. Empty DATA
    @Test(expected = OperationNotSupportedException.class)
    public void testCreateListWithNullParam() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    //Works properly
    //hasNext
    @Test
    public void testHasNextReturnCorrectBoolean() {
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    //move
    @Test
    public void testMove() {
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }

    //print
    //print w.o. elements
    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyData() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testIfPrintCorrectly() {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(DATA[index++], listIterator.print());
            listIterator.move();
        }
    }
}