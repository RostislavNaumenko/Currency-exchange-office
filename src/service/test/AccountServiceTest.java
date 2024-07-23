package service.test;

import model.Account;
import model.Currency;
import model.Transaction;
import model.TransactionType;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.AccountRepository;
import service.AccountService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    private AccountService accountService;
    private User user;
    private Currency currency;

    @BeforeEach
    void setUp() {
        accountService = new AccountService();
        user = new User(1, "test@example.com", "password", "John", "Smith");
        currency = new Currency("USD", "US Dollar");
    }

    @Test
    void addAccount() {
        Account account = accountService.addAccount(user, currency);
        assertNotNull(account);
        assertEquals(user, account.getUser());
        assertEquals(currency, account.getCurrency());
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void getAccountsByUserId() {
        accountService.addAccount(user, currency);
        accountService.addAccount(user, new Currency("EUR", "Euro"));
        List<Account> accounts = accountService.getAccountsByUserId(user.getId());
        assertEquals(2, accounts.size());
    }

    @Test
    void getAccountById() {
        Account account = accountService.addAccount(user, currency);
        Account retrievedAccount = accountService.getAccountById(account.getId());
        assertNotNull(retrievedAccount);
        assertEquals(account, retrievedAccount);
    }

    @Test
    void replenish() {
        Account account = accountService.addAccount(user, currency);
        accountService.replenish(account.getId(), 100.0, new Transaction(1, account, 100.0, null, TransactionType.DEBIT, currency));
        assertEquals(100.0, account.getBalance());
    }
    @Test
    void withdraw() {
        Account account = accountService.addAccount(user, currency);
        accountService.replenish(account.getId(), 200.0, new Transaction(1, account, 200.0, null, TransactionType.DEBIT, currency));
        accountService.withdraw(account.getId(), 50.0, new Transaction(2, account, 50.0, null, TransactionType.CREDIT, currency));
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void deposit() {
        Account account1 = accountService.addAccount(user, currency);
        Account account2 = accountService.addAccount(user, new Currency("EUR", "Euro"));
        accountService.replenish(account1.getId(), 100.0, new Transaction(1, account1, 100.0, null, TransactionType.DEBIT, currency));
        accountService.deposit(account2.getId(), new Transaction(2, account2, 50.0, null, TransactionType.CREDIT, currency));
        assertEquals(50.0, account2.getBalance());
    }

    @Test
    void credit() {
        Account account1 = accountService.addAccount(user, currency);
        Account account2 = accountService.addAccount(user, new Currency("EUR", "Euro"));
        accountService.replenish(account1.getId(), 100.0, new Transaction(1, account1, 100.0, null, TransactionType.DEBIT, currency));
        accountService.credit(account1.getId(), new Transaction(2, account2, 50.0, null, TransactionType.CREDIT, new Currency("EUR", "Euro")));
        assertEquals(50.0, account1.getBalance());
    }

    @Test
    void getTransactionsByAccountId() {
        Account account = accountService.addAccount(user, currency);
        accountService.replenish(account.getId(), 100.0, new Transaction(1, account, 100.0, null, TransactionType.DEBIT, currency));
        accountService.withdraw(account.getId(), 50.0, new Transaction(2, account, 50.0, null, TransactionType.CREDIT, currency));
        List<Transaction> transactions = accountService.getTransactionsByAccountId(account.getId());
        assertEquals(2, transactions.size());
    }

}