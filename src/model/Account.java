package model;

import java.util.Objects;

public class Account {

    private int id;
    private User user;
    private double balance;
    private Currency currency;

    public Account(int id, User user, double balance, Currency currency) {
        this.id = id;
        this.user = user;
        this.balance = balance;
        this.currency = currency;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        this.balance += amount;
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", balance=" + balance +
                ", currency=" + currency +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(id, account.id) && Objects.equals(user, account.user) && Objects.equals(currency, account.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, balance, currency);
    }
}
