package service;

import model.Account;
import model.Currency;
import model.Transaction;
import model.TransactionType;
import repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Account account, double amount, TransactionType type, Currency currency) {
        return  transactionRepository.addTransaction(account, amount, type, currency);
    }

    public Transaction getTransactionById(int id) {
        return transactionRepository.getTransactionById(id);
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactionRepository.getAllTransactions().values());
    }

    public List<Transaction> getTransactionsByAccount(Account account) {
        return transactionRepository.getAllTransactions().values().stream()
                .filter(transaction -> transaction.getAccount().equals(account))
                .collect(Collectors.toList());
    }

    public List<Transaction> getTransactionsByAccountAndType(Account account, TransactionType type) {
        return getTransactionsByAccount(account).stream()
                .filter(transaction -> transaction.getType().equals(type))
                .collect(Collectors.toList());
    }


}
