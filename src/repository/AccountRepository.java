package repository;

import model.Account;
import model.Currency;
import model.Transaction;
import model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class  AccountRepository {
    // Map для хранения аккаунтов пользователей: ключ - ID пользователя, значение - список аккаунтов пользователя
    private Map<Integer, List<Account>> userAccountsMap = new HashMap<>();
    // Map для хранения транзакций аккаунта: ключ - ID аккаунта, значение - список транзакций аккаунта
    private Map<Integer, List<Transaction>> accountsTransactions = new HashMap<>();

    private final AtomicInteger currentId = new AtomicInteger(1);

    // Метод для добавления нового аккаунта пользователя
    public Account addAccount(User user , Currency currency) {
        int accountId = currentId.getAndIncrement();
        List<Account> accounts = userAccountsMap.get(user.getId());
        Account account = new Account(accountId,user,0, currency);
        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        accounts.add(account);
            userAccountsMap.put(user.getId(), accounts);
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
        List<Transaction> transactions = accountsTransactions.get(accountId);
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);
            accountsTransactions.put(accountId, transactions);
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
    // Вспомогательный метод для поиска аккаунта по его ID
    public Account getAccountById(int accountId) {
        for (List<Account> accounts : userAccountsMap.values()) {
            for (Account account : accounts) {
                if (account.getId() == accountId) {
                    return account;
                }
            }
        }
        return null;
    }
    public List<Transaction> allTransactionsByUser(User user){
        return userAccountsMap.getOrDefault(user.getId(), Collections.emptyList())
                .stream()
                .map(Account::getId)
                .flatMap(accountId -> accountsTransactions.getOrDefault(accountId, Collections.emptyList()).stream())
                .collect(Collectors.toList());
    }

    public List<Account> getAllAccounts(){
        // Объявляем список для хранения всех аккаунтов
        List<Account> allAccounts = new ArrayList<>();

        // Проходимся по всем спискам аккаунтов для каждого пользователя
        for (List<Account> accounts : userAccountsMap.values()) {
            allAccounts.addAll(accounts); // Добавляем все аккаунты в общий список
        }
        return allAccounts;
    }


    // Метод для пополнения баланса аккаунта
    public void deposit(int accountId, double amount) {
        Account account = getAccountById(accountId);
        account.deposit(amount);
    }

    // Метод для снятия денег со счета
    public void withdraw(int accountId, double amount) {
        Account account = getAccountById(accountId);
        account.withdraw(amount);
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

