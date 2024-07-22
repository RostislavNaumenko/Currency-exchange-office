package model;


import java.util.Objects;

public class Currency {
    private String nameOfCurrency;
    private String code;

    public Currency(String code, String nameOfCurrency) {
        this.nameOfCurrency = nameOfCurrency;
        this.code = code;
    }


    public String getNameOfCurrency() {
        return nameOfCurrency;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Currency{" +
                ", nameOfCurrency='" + nameOfCurrency + '\'' +
                ", abbreviation='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(nameOfCurrency, currency.nameOfCurrency) && Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfCurrency, code);
    }
}


