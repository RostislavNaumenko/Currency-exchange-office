package service;

import model.Account;
import model.Currency;
import model.Transaction;
import model.User;
import repository.AccountRepository;
import repository.TransactionRepository;

import java.util.List;

public class AccountService {
    private AccountRepository accountRepository = new AccountRepository();


    // Метод для добавления нового аккаунта
    public Account addAccount(User user, Currency currency) {
        return accountRepository.addAccount(user, currency);
    }

    // Метод для получения списка аккаунтов пользователя
    public List<Account> getAccountsByUserId(int userId) {
        return accountRepository.getAccountsByUserId(userId);
    }


    // Вспомогательный метод для поиска аккаунта по его ID
    public Account getAccountById(int accountId) {
        return accountRepository.getAccountById(accountId);
    }

    // Метод для пополнения баланса аккаунта
    public void deposit(int accountId, double amount, Transaction transaction) {
        if(amount <= 0) throw new IllegalArgumentException("Нельзя выполнить операцию с " + amount);
        Account account = accountRepository.getAccountById(accountId);
        if (account != null) {
            accountRepository.deposit(accountId, amount);
            accountRepository.addTransaction(accountId, transaction);
        } else {
            throw new IllegalArgumentException("Аккаунт не найден " + accountId);
        }
    }

    // Метод для снятия средств с аккаунта
    public void withdraw(int accountId, double amount, Transaction transaction) {
        Account account = accountRepository.getAccountById(accountId);
        if (account != null) {
            if (account.getBalance() >= amount) {
                accountRepository.withdraw(accountId, amount);
                accountRepository.addTransaction(accountId, transaction);
            } else {
                throw new IllegalArgumentException("Недостаточно средств");
            }
        } else {
            throw new IllegalArgumentException("Аккаунт не найден " + accountId);
        }
    }

    // Метод для добавления транзакции аккаунта
//    public Transaction addTransaction ( int accountId, Transaction transaction){
//        return accountRepository.addTransaction(accountId, transaction);
//    }

    // Метод для получения списка транзакций по ID аккаунта
    public List<Transaction> getTransactionsByAccountId(int accountId) {
        return accountRepository.getTransactionsByAccountId(accountId);
    }
}
