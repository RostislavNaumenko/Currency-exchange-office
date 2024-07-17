package model;

import java.util.Objects;

public class Currencies {
    private String id;
    private String nameOfCurrency;
    private String abbreviation;

    public static final Currencies EUR = new Currencies("1", "Euro", "EUR");
    public static final Currencies USD = new Currencies("2", "Dollar", "USD");
    public static final Currencies UAH = new Currencies("3", "Hryvnia", "UAH");

    public Currencies(String id, String nameOfCurrency, String abbreviation) {
        this.id = id;
        this.nameOfCurrency = nameOfCurrency;
        this.abbreviation = abbreviation;
    }

    public String getId() {
        return id;
    }

    public String getNameOfCurrency() {
        return nameOfCurrency;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public String toString() {
        return "Currencies{" +
                "id='" + id + '\'' +
                ", nameOfCurrency='" + nameOfCurrency + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currencies that = (Currencies) o;
        return Objects.equals(id, that.id) && Objects.equals(nameOfCurrency, that.nameOfCurrency) && Objects.equals(abbreviation, that.abbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfCurrency, abbreviation);
    }

}
