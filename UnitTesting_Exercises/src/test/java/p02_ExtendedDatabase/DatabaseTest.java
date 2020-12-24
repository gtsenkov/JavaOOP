package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Person[] PEOPLE = {new Person(1, "First"),
            new Person(2, "Second"), new Person(3, "Third")};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    //Constructor Testing
    //1.връща ли правилен обект -> елементите и брой на елементите
    @Test
    public void testConstructorHasToCreateValidObject () throws OperationNotSupportedException {
        Person [] databaseNumbers = database.getElements();
        //ЕЛЕМЕНТИТЕ
        //БРОЙ НА ЕЛЕМЕНТИТЕ
        Assert.assertEquals("Count of elements is incorrect", PEOPLE.length, databaseNumbers.length);
        for (int i = 0; i < databaseNumbers.length; i++) {
            Assert.assertEquals(PEOPLE[i], databaseNumbers[i]);
        }
    }
    //2. случай елемените са над 16
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseMoreThanSixteenElements () throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new p01_Database.Database(numbers);
    }
    //3. случай елементите са под 1
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseLessThanOneElement () throws OperationNotSupportedException {
        Person[] numbers = new Person[0];
        new Database(numbers);
    }

    //Add method testing

    //1. подаване на null елемент
    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExWhenParamNull () throws OperationNotSupportedException {
        database.add(null);
    }

    //2. правилна работа, добавя елемента в масива
    @Test
    public void testAddShouldAddElement () throws OperationNotSupportedException {
        //p1, p2, p3
        database.add(new Person(4, "Forth"));
        //p1, p2, p3, p4
        Assert.assertEquals(4, database.getElements().length);
        Assert.assertEquals(4, database.getElements()[3].getId());
        Assert.assertEquals("Forth", database.getElements()[3].getUsername());
    }

    //Remove method testing
    //1. нямаме елементи
    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExWithEmptyData () throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        //{} празен масив
        database.remove();
    }
    //2. дали премахва последния елемент
    @Test
    public void testRemoveLastElement () throws OperationNotSupportedException {
        //p1, p2, p3
        database.remove();
        //p1,p2
        Person [] elementsInDatabase = database.getElements();
        Assert.assertEquals(PEOPLE.length - 1, elementsInDatabase.length);
        Assert.assertEquals(2, elementsInDatabase[elementsInDatabase.length - 1].getId());
        Assert.assertEquals("Second", elementsInDatabase[elementsInDatabase.length - 1].getUsername());
        for (int i = 0; i < elementsInDatabase.length; i++) {
            Assert.assertEquals(elementsInDatabase[i], PEOPLE[i]);
        }
    }

    //find by user name
    //1. If argument is null
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowsExWithNullUsername() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    //2. Database is empty
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowExWithEmptyData() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findByUsername("First");
    }

    //3. If there is not 1 coincidence
    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameThrowsExceptionIfSizeIsNotEqualToOne() throws OperationNotSupportedException {
        database = new Database(); //empty base
        database.findByUsername("First");
    }

    //4. Person is found and finding is correct
    @Test
    public void testFindByUsernameReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findByUsername("First");
        Assert.assertEquals("First", resultPerson.getUsername());
    }

    //find by id
    //1. there is no people in database
    @Test(expected =  OperationNotSupportedException.class)
    public void testFindByIdThrowExWithEmptyData() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findById(1);
    }

    //2. if found id is exact 1
    @Test (expected = OperationNotSupportedException.class)
    public void testFindByIdThrowsExIfFoundIsNot1() throws OperationNotSupportedException {
        database = new Database();
        database.findById(1);
    }

    //3. found correct Person
    @Test
    public void testFindByIdReturnsCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findById(1);
        Assert.assertEquals("First", resultPerson.getUsername());
        Assert.assertEquals(1, resultPerson.getId());

        Person resultPerson2 = database.findById(2);
        Assert.assertEquals("Second", resultPerson2.getUsername());
        Assert.assertEquals(2, resultPerson2.getId());

    }

}