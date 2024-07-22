package repository;

import model.Currency;
import model.Rate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CurrencyRepository {
    // Map для хранения текущего курса валют: ключ - код валюты, значение - объект Rate
    Map<String, Rate> currenciesRate;
    // Map для хранения валют: ключ - code валюты, значение - объект Currency
    Map<String, Currency> currenciesMap;
    // Map для хранения истории курсов валют: ключ - код валюты, значение - список курсов (Rate) для данной валюты
    Map<String, List<Rate>> history;

    // генерация ID для валют
    private final AtomicInteger currencyIdCounter = new AtomicInteger(1);

    public CurrencyRepository() {
        this.currenciesRate = new HashMap<>();
        this.currenciesMap = new HashMap<>();
        this.history = new HashMap<>();
        initTestData();
    }

    private void initTestData() {
        List<Currency> currencies = List.of(
                new Currency("EUR", "Euro"),
                new Currency("USD", "Dollar USA"),
                new Currency("GBP", "UK pound sterling"),
                new Currency("PLN", "Polish zloty"),
                new Currency("CZK", "Czech krone")
        );

        for (Currency currency : currencies) {
            currenciesMap.put(currency.getCode(), currency);
        }

        Rate rateEUR = new Rate(1.0);
        Rate rateUSD = new Rate(0.93689147);
        Rate rateGBP = new Rate(1.1604073);
        Rate ratePLN = new Rate(0.21496);
        Rate rateCZK = new Rate(0.0406557);

        currenciesRate.put("EUR", rateEUR);
        currenciesRate.put("USD", rateUSD);
        currenciesRate.put("GBP", rateGBP);
        currenciesRate.put("PLN", ratePLN);
        currenciesRate.put("CZK", rateCZK);


        addRateToHistory("EUR", rateEUR);
        addRateToHistory("USD", rateUSD);
        addRateToHistory("GBP", rateGBP);
        addRateToHistory("PLN", ratePLN);
        addRateToHistory("CZK", rateCZK);

    }



    public Map<String, Rate> getCurrenciesRate() {
        return currenciesRate;
    }

    public Map<String, Currency> getCurrenciesMap() {
        return currenciesMap;
    }

    public Map<String, List<Rate>> getHistory() {
        return history;
    }

    public Currency getCurrencyByCode(String currencyCode) {
        return currenciesMap.getOrDefault(currencyCode, null);
    }

   // Метод для получения текущего курса валюты
    public Rate getRateForCurrency(String currencyCode) {
        return currenciesRate.get(currencyCode);
    }

    // Метод для получения истории курсов валюты
    public List<Rate> getRateHistoryForCurrency(String currencyCode) {
        return history.getOrDefault(currencyCode, new ArrayList<>());
    }

    public void addCurrency(String nameOfCurrency, String code) {
        int id = currencyIdCounter.getAndIncrement();
        Currency currency = new Currency(nameOfCurrency, code);
        currenciesMap.put(code, currency);
    }

    public void updateRate(String currencyCode, double rateValue) {
        Currency currency = currenciesMap.get(currencyCode);
        if (currency != null) {
            Rate rate = new Rate(rateValue);
            currenciesRate.put(currencyCode, rate);
            addRateToHistory(currencyCode, rate);

        } else {
            System.out.println("Валюта не найдена: " + currencyCode);
        }
    }

    public void addRateToHistory(String curCode, Rate rate) {
        history.merge(curCode, new ArrayList<>(List.of(rate)), (oldList, newList) -> {
            oldList.addAll(newList);
            return oldList;
        });
    }

    public void addRateToHistory(Currency currency, Rate rate) {
        addRateToHistory(currency.getCode(), rate);
    }


}
