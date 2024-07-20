package model;

import java.util.Objects;

public class Rate {
    private Currency currency;
    private double rate;

    public Rate(Currency currency, double rate) {
        this.currency = currency;
        this.rate = rate;
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
                ", currency=" + currency +
                ", rate=" + rate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate1 = (Rate) o;
        return Double.compare(rate, rate1.rate) == 0 && Objects.equals(currency, rate1.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, rate);
    }
}
