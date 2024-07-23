package service.test;

import model.Role;
import model.Account;
import model.Currency;
import model.Transaction;
import model.TransactionType;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.UserService;
import repository.TransactionRepository;
import service.TransactionService;

import java.util.Map;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    private TransactionService transactionService;
    private Account account;
    private Currency currency;

    @BeforeEach
    void setUp() {
        transactionService = new TransactionService();
        currency = new Currency("USD", "US Dollar");
        account = new Account(1, new User(1, "test@example.com", "password", "John", "Smith"), 1000.0, currency);
    }

    @Test
    void createTransaction() {
        Transaction transaction = transactionService.createTransaction(account, 100.0, TransactionType.DEBIT, currency);
        assertNotNull(transaction);
        assertEquals(100.0, transaction.getAmount());
        assertEquals(TransactionType.DEBIT, transaction.getType());
        assertEquals(currency, transaction.getCurrency());
        assertEquals(account, transaction.getAccount());
    }

    @Test
    void getTransactionById() {
        Transaction transaction = transactionService.createTransaction(account, 100.0, TransactionType.DEBIT, currency);
        Transaction retrievedTransaction = transactionService.getTransactionById(transaction.getId());
        assertNotNull(retrievedTransaction);
        assertEquals(transaction, retrievedTransaction);
    }

    @Test
    void getAllTransactions() {
        transactionService.createTransaction(account, 100.0, TransactionType.DEBIT, currency);
        transactionService.createTransaction(account, 50.0, TransactionType.CREDIT, currency);
        List<Transaction> allTransactions = transactionService.getAllTransactions();
        assertEquals(2, allTransactions.size());
    }

    @Test
    void getTransactionsByAccount() {
        transactionService.createTransaction(account, 100.0, TransactionType.DEBIT, currency);
        transactionService.createTransaction(account, 50.0, TransactionType.CREDIT, currency);
        List<Transaction> transactions = transactionService.getTransactionsByAccount(account);
        assertEquals(2, transactions.size());
    }

    @Test
    void getTransactionsByAccountAndType() {
        transactionService.createTransaction(account, 100.0, TransactionType.DEBIT, currency);
        transactionService.createTransaction(account, 50.0, TransactionType.CREDIT, currency);
        List<Transaction> debitTransactions = transactionService.getTransactionsByAccountAndType(account, TransactionType.DEBIT);
        assertEquals(1, debitTransactions.size());
        List<Transaction> creditTransactions = transactionService.getTransactionsByAccountAndType(account, TransactionType.CREDIT);
        assertEquals(1, creditTransactions.size());
    }

}


