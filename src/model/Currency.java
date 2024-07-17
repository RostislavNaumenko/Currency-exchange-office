package model;


import java.util.Objects;

public class Currency {
    private String id;
    private String nameOfCurrency;
    private String abbreviation;

    public static final Currency EUR = new Currency("1", "Euro", "EUR");
    public static final Currency USD = new Currency("2", "Dollar", "USD");
    public static final Currency UAH = new Currency("3", "Hryvnia", "UAH");

    public Currency(String id, String nameOfCurrency, String abbreviation) {
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
        return "Currency{" +
                "id='" + id + '\'' +
                ", nameOfCurrency='" + nameOfCurrency + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency that = (Currency) o;
        return Objects.equals(id, that.id) && Objects.equals(nameOfCurrency, that.nameOfCurrency) && Objects.equals(abbreviation, that.abbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfCurrency, abbreviation);
    }
}


