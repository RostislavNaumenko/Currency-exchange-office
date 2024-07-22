package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Rate {
    private double rate;
    private final LocalDateTime time;

    public Rate( double rate) {
        this.rate = rate;
        this.time = LocalDateTime.now();
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
                "rate=" + rate +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate1 = (Rate) o;
        return Double.compare(rate, rate1.rate) == 0 && Objects.equals(time, rate1.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, time);
    }
}
