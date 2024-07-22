package service;

import model.Account;
import model.Currency;
import model.Transaction;
import model.User;
import repository.AccountRepository;
import repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

public class AccountService {
    private AccountRepository accountRepository = new AccountRepository();

    // Метод для добавления нового аккаунта
    public Account addAccount(User user, Currency currency) {
        Optional<Account> account = accountRepository.getAccountsByUserId(user.getId()).stream()
                .filter(account1 -> account1.getCurrency().equals(currency))
                .findFirst();
        if (account.isPresent()) throw new IllegalArgumentException("This account already exist");

        return accountRepository.addAccount(user, currency);
    }

    // Метод для получения списка аккаунтов пользователя
    public List<Account> getAccountsByUserId(int userId) {
        return accountRepository.getAccountsByUserId(userId);
    }

    // Метод для получения списка всех транзакций пользователя
    public List<Transaction> allTransactionsByUser(User user) {
        return accountRepository.allTransactionsByUser(user);
    }

    // Вспомогательный метод для поиска аккаунта по его ID
    public Account getAccountById(int accountId) {
        Optional<Account> account = accountRepository.getAllAccounts().stream()
                .filter(account1 -> account1.getId() == accountId)
                .findAny();
        if (account.isEmpty()) throw new IllegalArgumentException("No account match: " + accountId);
        return accountRepository.getAccountById(accountId);
    }

    // Метод для пополнения баланса аккаунта
    public void replenish(int accountId, double amount, Transaction transaction) {
        Account account = accountRepository.getAccountById(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Аккаунт не найден " + accountId);
        }
        accountRepository.deposit(accountId, amount);
        accountRepository.addTransaction(accountId, transaction);
    }

    // Метод для снятия средств с аккаунта
    public void withdraw(int accountId, double amount, Transaction transaction) {
        Account account = accountRepository.getAccountById(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Аккаунт не найден " + accountId);
        }

        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Недостаточно средств");
        }
        accountRepository.withdraw(accountId, amount);
        accountRepository.addTransaction(accountId, transaction);
    }

    // Метод для получения денег с другого счета
    public void deposit(int toAccountId, Transaction transaction) {
        accountRepository.deposit(toAccountId, transaction.getAmount());
        accountRepository.addTransaction(toAccountId, transaction);
    }


    // Метод для отправки средств с аккаунта
    public void credit (int fromAccountId, Transaction transaction) {
        accountRepository.withdraw(fromAccountId,  transaction.getAmount());
        accountRepository.addTransaction(fromAccountId, transaction);
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
