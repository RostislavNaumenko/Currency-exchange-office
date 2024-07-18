package model;

import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private Account account;
    private double amount;
    private LocalDateTime timestamp;
    private String type; // DEBIT or CREDIT

    public Transaction(String id, Account account, double amount, LocalDateTime timestamp, String type) {
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.timestamp = timestamp;
        this.type = type;
    }

    // Getters and setters
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", account=" + account +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", type='" + type + '\'' +
                '}';
    }
}
