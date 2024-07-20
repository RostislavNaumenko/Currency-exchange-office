package repository;

import model.Account;
import model.Currency;
import model.Transaction;
import model.TransactionType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionRepository {
    // Map для хранения транзакций: ключ - ID транзакции, значение - объект Transaction
    private Map<Integer, Transaction> transactionsMap = new HashMap<>();

    private final AtomicInteger currentId = new AtomicInteger(1);

    public Transaction addTransaction(Account account, double amount, TransactionType type, Currency currency) {
        Integer id = currentId.getAndIncrement();
        LocalDateTime timestamp = LocalDateTime.now();
        Transaction transaction = new Transaction(id, account, amount, timestamp, type, currency);
        transactionsMap.put(transaction.getId(), transaction);
        return transaction;
    }

    public Transaction getTransactionById(int id) {
        return transactionsMap.get(id);
    }

    public Map<Integer, Transaction> getAllTransactions() {
        return new HashMap<>(transactionsMap);
    }


}
