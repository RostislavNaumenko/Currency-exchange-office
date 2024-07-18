package model;

import java.util.Objects;

public class Rate {
    private String id;
    private Currency currency;
    private double rate;

    public Rate(String id, Currency currency, double rate) {
        this.id = id;
        this.currency = currency;
        this.rate = rate;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id='" + id + '\'' +
                ", currency=" + currency +
                ", rate=" + rate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate1 = (Rate) o;
        return Double.compare(rate, rate1.rate) == 0 && Objects.equals(id, rate1.id) && Objects.equals(currency, rate1.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currency, rate);
    }
}
