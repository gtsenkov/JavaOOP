package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] NUMBERS = {5, 9, 29, 45};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    //Constructor Testing
    //1.връща ли правилен обект -> елементите и брой на елементите
    @Test
    public void testConstructorHasToCreateValidObject() throws OperationNotSupportedException {
        Integer[] databaseNumbers = database.getElements();

        //БРОЙ НА ЕЛЕМЕНТИТЕ
        Assert.assertEquals("Count of elements is incorrect", NUMBERS.length, databaseNumbers.length);
        //ЕЛЕМЕНТИТЕ
        for (int i = 0; i < databaseNumbers.length; i++) {
            Assert.assertEquals(NUMBERS[i], databaseNumbers[i]);
        }
    }

    //2. случай елемените са над 16
    @Test(expected = OperationNotSupportedException.class)
    public void testIfConstructorThrowsExceptionWhenElementsAreMoreThanSixteen() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    //3. if elements are under 1
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionIfElementsAreUnder1() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    //Add method testing

    //1. if given elements are null
    @Test(expected = OperationNotSupportedException.class)
    public void testShouldThrowExceptionWhenAddingNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    //2. if adding works correctly
    @Test
    public void testIfAddingWorksCorrectly() throws OperationNotSupportedException {
        Integer numberToAdd = 17;
        int initialLength = database.getElements().length;
        database.add(numberToAdd);
        Assert.assertEquals(initialLength + 1, database.getElements().length);
        Assert.assertEquals(numberToAdd, database.getElements()[database.getElements().length - 1]);
    }

    //Remove method testing
    //1. If there are not elements
    @Test(expected = OperationNotSupportedException.class)
    public void testIfRemoveThrowsExceptionWhenDatabaseIsEmpty() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        Integer elementBeforeLastOne = database.getElements()[database.getElements().length - 2];
        database.remove();
        Integer[] elementsInDatabase = database.getElements();
        Assert.assertEquals(NUMBERS.length - 1, elementsInDatabase.length);
        Assert.assertEquals(elementBeforeLastOne, elementsInDatabase[elementsInDatabase.length -1]);
    }
}