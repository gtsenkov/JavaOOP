import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{
    private Map<Integer, Transaction> transactionsByIds;

    public ChainblockImpl() {
        transactionsByIds = new LinkedHashMap<>();
    }

    public int getCount() {
        return this.transactionsByIds.size();
    }

    public void add(Transaction transaction) {

        int id = transaction.getId();
        if (!contains(id)) {
            this.transactionsByIds.put(id, transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactionsByIds.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }
        this.transactionsByIds.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }
        this.transactionsByIds.remove(id);
    }

    public Transaction getById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }
        return this.transactionsByIds.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction transaction : transactionsByIds.values()) {
            if (transaction.getStatus() == status) {
                transactionList.add(transaction);
            }

        }
        if (transactionList.size() == 0) {
            throw new IllegalArgumentException();
        }

        transactionList.sort(Comparator.comparing(Transaction::getAmount).reversed());
        return transactionList;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();
        getByTransactionStatus(status).forEach(transactions::add);
        return transactions.stream().map(Transaction::getFrom).collect(Collectors.toList());
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();
        getByTransactionStatus(status).forEach(transactions::add);
        return transactions.stream().map(Transaction::getTo).collect(Collectors.toList());

    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactionsByIds.values()
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : transactionsByIds.values()) {
            if (transaction.getFrom().equals(sender)) {
                transactions.add(transaction);
            }
        }
        if (transactions.size() == 0) {
            throw new IllegalArgumentException();
        }

        return transactions.stream().sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : transactionsByIds.values()) {
            if (transaction.getTo().equals(receiver)) {
                transactions.add(transaction);
            }
        }
        if (transactions.size() == 0) {
            throw new IllegalArgumentException();
        }

        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {

        return this.transactionsByIds.values().stream()
                .filter(t -> t.getStatus() == status)
                .filter(t -> t.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : transactionsByIds.values()) {
            if (transaction.getFrom().equals(sender) && transaction.getAmount() > amount) {
                transactions.add(transaction);
            }
        }
        if (transactions.size() == 0) {
            throw new IllegalArgumentException();
        }

        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : transactionsByIds.values()) {
            if (transaction.getTo().equals(receiver) && transaction.getAmount() <= lo
            && transaction.getAmount() > hi) {
                transactions.add(transaction);
            }
        }
        if (transactions.size() == 0) {
            throw new IllegalArgumentException();
        }

        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return this.transactionsByIds.values().stream()
                .filter(t -> t.getAmount() >= lo && t.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return (Iterator<Transaction>) this.transactionsByIds.values();
    }
}
