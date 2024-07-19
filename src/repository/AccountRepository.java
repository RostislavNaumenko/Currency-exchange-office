package repository;

import model.Account;
import model.Transaction;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class AccountRepository {
    // Map для хранения аккаунтов пользователей: ключ - ID пользователя, значение - список аккаунтов пользователя
    private Map<Integer, List<Account>> userAccountsMap = new HashMap<>();
    // Map для хранения транзакций аккаунта: ключ - ID аккаунта, значение - список транзакций аккаунта
    private Map<Integer, List<Transaction>> accountsTransactions = new HashMap<>();
    private final AtomicInteger currentId = new AtomicInteger(1);

    // Метод для добавления нового аккаунта пользователя
    public Account addAccount(int userId, Account account) {
        userId = currentId.getAndIncrement();
        List<Account> accounts = userAccountsMap.get(userId);
        if (accounts == null) {
            accounts = new ArrayList<>();
            userAccountsMap.put(userId, accounts);
        }
        accounts.add(account);
        return account;
    }
    // Метод для получения списка аккаунтов пользователя по его ID
    public List<Account> getAccountsByUserId(int userId) {
        List<Account> accounts = userAccountsMap.get(userId);
        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        return accounts;
    }
    // Метод для добавления транзакции аккаунта
    public Transaction addTransaction(int accountId, Transaction transaction) {
        accountId = currentId.getAndIncrement();
        List<Transaction> transactions = accountsTransactions.get(accountId);
        if (transactions == null) {
            transactions = new ArrayList<>();
            accountsTransactions.put(accountId, transactions);
        }
        transactions.add(transaction);
        return transaction;
    }
    // Метод для получения списка транзакций по ID аккаунта
    public List<Transaction> getTransactionsByAccountId(int accountId) {
        List<Transaction> transactions = accountsTransactions.get(accountId);
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        return transactions;
    }
}


/*
    // Метод для добавления нового аккаунта пользователя
    public void addAccount(int userId, Account account) {
        // Если у пользователя нет аккаунтов, создаем новый список и добавляем аккаунт
        userAccountsMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(account);
    }

    // Метод для получения списка аккаунтов пользователя по его ID
    public List<Account> getAccountsByUserId(int userId) {
        // Возвращаем список аккаунтов пользователя или пустой список, если аккаунтов нет
        return userAccountsMap.getOrDefault(userId, new ArrayList<>());
    }

    // Метод для добавления транзакции аккаунта
    public void addTransaction(int accountId, Transaction transaction) {
        // Если у аккаунта нет транзакций, создаем новый список и добавляем транзакцию
        accountsTransactions.computeIfAbsent(accountId, k -> new ArrayList<>()).add(transaction);
    }

    // Метод для получения списка транзакций по ID аккаунта
    public List<Transaction> getTransactionsByAccountId(int accountId) {
        // Возвращаем список транзакций аккаунта или пустой список, если транзакций нет
        return accountsTransactions.getOrDefault(accountId, new ArrayList<>());
    }
}


 */

