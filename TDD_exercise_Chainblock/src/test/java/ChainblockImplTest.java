import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private Chainblock chainblock;
    private List<Transaction> transactionList;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
        this.createTransactions();
    }

    //Contains

    @Test
    public void testContainsByIdReturnCorrectValue() {
        assertFalse(chainblock.contains(transactionList.get(0).getId()));
        chainblock.add(transactionList.get(0));
        assertTrue(chainblock.contains(transactionList.get(0).getId()));

    }
    //Add -> valid id or duplicate id

    @Test
    public void testAddHasToAddTransactionToChainBlock() {
        chainblock.add(transactionList.get(0));
        assertEquals(1, chainblock.getCount());
    }
    @Test
    public void testAddHasToAddTransactionWhenDuplicateId() {
        chainblock.add(transactionList.get(0));
        assertEquals(1, chainblock.getCount());
        chainblock.add(transactionList.get(0));
        assertEquals(1, chainblock.getCount());
    }

    //changeTransactionStatus -> valid change or throws exception

    @Test
    public void testChangeTransactionStatusHasToChangeCorrectly() {
        chainblock.add(transactionList.get(0));
        chainblock.changeTransactionStatus(transactionList.get(0).getId(), TransactionStatus.FAILED);
        assertEquals(TransactionStatus.FAILED, transactionList.get(0).getStatus());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusTrowWhenTransactionNotPresent() {
        chainblock.changeTransactionStatus(transactionList.get(0).getId(), TransactionStatus.FAILED);
    }

    //testRemoveTransactionById -> valid remove or throws exception

    @Test
    public void testRemoveTransactionByIdRemovesCorrectTransaction() {
        fillChainBlock();
        assertEquals(4, this.chainblock.getCount());
        chainblock.removeTransactionById(transactionList.get(0).getId());
        assertEquals(3, this.chainblock.getCount());
        assertFalse(chainblock.contains(transactionList.get(0).getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdWhenTransactionNotPresent() {
        fillChainBlock();
        chainblock.removeTransactionById(chainblock.getCount() + 1);
    }

    //getById -> returns correct transaction or there is not such transaction

    @Test
    public void testGetByIdHasToReturnCorrectTransaction() {
        fillChainBlock();
        Transaction expected = this.transactionList.get(2);
        Transaction actual = this.chainblock.getById(expected.getId());
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdHasToThrowExIfNotPresent() {
        fillChainBlock();
        this.chainblock.getById(10);
    }

    //getByTransactionStatus -> 1.no transaction with such status and throws exception
    //2. are all transactions with searched status
    //3. are transactions sorted

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusHasToThrowIfStatusNotExist() {
        fillChainBlock();
        chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetByTransactionStatusReturnCorrectTransactions() {
        fillChainBlock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(result);
        List<Transaction> actual = convertIterableToList(result);
        //check quantity
        assertEquals(expected.size(), actual.size());
        //check status
        for (Transaction transaction : actual) {
            assertEquals(TransactionStatus.SUCCESSFUL, transaction.getStatus());
        }
    }

    @Test
    public void testGetByTransactionStatusReturnCorrectTransactionsInCorrectOrder() {
        fillChainBlock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(result);
        List<Transaction> actual = convertIterableToList(result);
        //check quantity
        assertEquals(expected.size(), actual.size());
        //check order
        assertEquals(expected,actual);
    }

    //getAllSendersWithTransactionStatus
    //1. not transactions with such status
    //2. if returns all senders with searched status
    //3. if returns all senders in correct order
    //4. check if there are duplicated senders

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusHasToThrowIfStatusNotExist() {
        fillChainBlock();
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusHasToReturnCorrectSendersInCorrectOrder() {
        fillChainBlock();
        List<String> expected = transactionList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getStatus).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        Iterable<String> senders = chainblock.getAllSendersWithTransactionStatus(
                TransactionStatus.SUCCESSFUL);
        assertNotNull(senders);
        List<String> actual = new ArrayList<>();
        senders.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        for (String sender : actual) {
            assertEquals("From", sender);
        }
        assertEquals(expected, actual);
    }

    //getAllReceiversWithTransactionStatus
    //1. not transactions with such status
    //2. if returns all Receivers with searched status
    //3. if returns all Receivers in correct order
    //4. check if there are duplicated Receivers

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusHasToThrowIfStatusNotExist() {
        fillChainBlock();
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusHasToReturnCorrectReceiversInCorrectOrder() {
        fillChainBlock();
        List<String> expected = transactionList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getStatus).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        Iterable<String> receivers = chainblock.getAllReceiversWithTransactionStatus(
                TransactionStatus.SUCCESSFUL);
        assertNotNull(receivers);
        List<String> actual = new ArrayList<>();
        receivers.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        for (String receiver : actual) {
            assertEquals("To", receiver);
        }
        assertEquals(expected, actual);
    }

    //getAllOrderedByAmountDescendingThenById
    //check if result is correct by amount then by id
    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdWorksCorrectly() {
        fillChainBlock();
        List<Transaction> expected = this.transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
        Iterable<Transaction> all = chainblock.getAllOrderedByAmountDescendingThenById();
        assertNotNull(all);
        List<Transaction> actual = convertIterableToList(all);
        assertEquals(expected, actual);
    }

    //getBySenderOrderedByAmountDescending
    //if there is no such sender
    //if senders are correct and ordered

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingHasToThrowIfSenderNotPresent() {
        fillChainBlock();
        chainblock.getBySenderOrderedByAmountDescending("Goshko");
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingHasReturnCorrectResult() {
        fillChainBlock();
        List<Transaction> expected = this.transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount))
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getBySenderOrderedByAmountDescending("From");
        assertNotNull(result);

        List<Transaction> actual = convertIterableToList(result);

        assertEquals(expected.size(), actual.size());
        double startAmount = 10.90;
        for (Transaction transaction : actual) {
            assertEquals("From", transaction.getFrom());
            assertEquals(startAmount - 0.10, transaction.getAmount(), 0.01);
            startAmount -= 0.10;
        }
    }

    //getByReceiverOrderedByAmountThenById
    //check if returns all transactions with given receiver ordered by amount descending
    //then by id ascending
    //if no such receiver throws exception

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenByIdIfNoSuchReceiver() {
        fillChainBlock();
        chainblock.getByReceiverOrderedByAmountThenById("Goshko");
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenByIdIfWorksCorrect() {
        fillChainBlock();
        List<Transaction> expected = this.transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getByReceiverOrderedByAmountThenById("To");
        assertNotNull(result);

        List<Transaction> actual = convertIterableToList(result);

        assertEquals(expected, actual);

    }

    //	getByTransactionStatusAndMaximumAmount

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnCorrectly() {
        fillChainBlock();
        List<Transaction> expected = transactionList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .filter(t -> t.getAmount() <= 10.7)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock
                .getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 10.7);
        assertNotNull(result);

        List<Transaction> actual = convertIterableToList(result);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyCollection() {
        fillChainBlock();
        Iterable<Transaction> result = chainblock
                .getByTransactionStatusAndMaximumAmount(TransactionStatus.UNAUTHORIZED, 10.7);
        assertNotNull(result);

        List<Transaction> actual = convertIterableToList(result);
        assertTrue(actual.isEmpty());
    }

    //	getBySenderAndMinimumAmountDescending
    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingThrowsException() {
        fillChainBlock();
        chainblock.getBySenderAndMinimumAmountDescending("Goshko", 1.0);
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescendingReturnsCorrectly() {
        fillChainBlock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getFrom().equals("From"))
                .filter(t -> t.getAmount() > 10.7)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock
                .getBySenderAndMinimumAmountDescending("From", 10.7);
        assertNotNull(result);

        List<Transaction> actual = convertIterableToList(result);

        assertEquals(expected, actual);
    }

    //•	getByReceiverAndAmountRange

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeThrowsException() {
        fillChainBlock();
        this.chainblock.getByReceiverAndAmountRange("Goshko", 1.0, 5.0);
    }

    @Test
    public void testGetByReceiverAndAmountRangeReturnsCorrectly() {
        fillChainBlock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getTo().equals("To"))
                .filter(t -> t.getAmount() <= 10.8 && t.getAmount() > 10.6)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock
                .getByReceiverAndAmountRange("To", 10.8, 10.6);
        assertNotNull(result);

        List<Transaction> actual = convertIterableToList(result);

        assertEquals(expected, actual);

    }

    //•	getAllInAmountRange

    @Test
    public void testGetAllInAmountRangeReturnEmptyCollection() {
        fillChainBlock();
        Iterable<Transaction> transactions = chainblock.getAllInAmountRange(1000.0, 1.0);
        List<Transaction> result = convertIterableToList(transactions);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetAllInAmountRangeReturnsCorrectly() {
        fillChainBlock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getAmount() >= 10.6 && t.getAmount() <= 10.8)
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock
                .getAllInAmountRange(10.6, 10.8);
        assertNotNull(result);

        List<Transaction> actual = convertIterableToList(result);

        assertEquals(expected, actual);
    }



        private List<Transaction> convertIterableToList(Iterable<Transaction> result) {
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);
        return actual;
    }

    private void fillChainBlock() {
        for (Transaction transaction : transactionList) {
            this.chainblock.add(transaction);
        }
    }

    private void createTransactions() {
        this.transactionList = new ArrayList<>();
        Transaction t1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "From", "To", 10.50);
        Transaction t2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "From", "To", 10.60);
        Transaction t3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "From", "To", 10.70);
        Transaction t4 = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "From", "To", 10.80);

        this.transactionList.add(t1);
        this.transactionList.add(t2);
        this.transactionList.add(t3);
        this.transactionList.add(t4);
    }
    //random transactions status generator
    // -> TransactionStatus[] statuses = TransactionStatus.values();
    //fori...
    // new TransactionImpl(i, statuses[i % statuses.length], from + i, to + i, 10,5 + i)
}