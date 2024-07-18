package model;

public class Account {

    private String id;
    private User user;
    private double balance;
    private Currency currency;

    public Account(String id, User user, double balance, Currency currency) {
        this.id = id;
        this.user = user;
        this.balance = balance;
        this.currency = currency;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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
}
