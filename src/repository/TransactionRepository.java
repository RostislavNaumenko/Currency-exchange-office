package repository;

import model.Transaction;

import java.util.HashMap;
import java.util.Map;

public class TransactionRepository {
    // Map для хранения транзакций: ключ - ID транзакции, значение - объект Transaction
    private Map<String, Transaction> transactionsMap = new HashMap<>();
}
