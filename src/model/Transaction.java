package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private String id;
    private Account account;
    private double amount;
    private LocalDateTime timestamp;
    private TransactionType type; // DEBIT or CREDIT
    private Currency currency;  // Добавлено поле валюты

    public Transaction(String id, Account account, double amount, LocalDateTime timestamp, TransactionType type, Currency currency) {
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.timestamp = timestamp;
        this.type = type;
        this.currency = currency;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", account=" + account +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(id, that.id) && Objects.equals(account, that.account) && Objects.equals(timestamp, that.timestamp) && type == that.type && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, amount, timestamp, type, currency);
    }
}
