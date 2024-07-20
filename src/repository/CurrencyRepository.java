package repository;

import model.Currency;
import model.Rate;

import java.util.ArrayList;
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

    public Map<String, Rate> getCurrenciesRate() {
        return currenciesRate;
    }

    public Map<String, Currency> getCurrenciesMap() {
        return currenciesMap;
    }

    public Map<String, List<Rate>> getHistory() {
        return history;
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
        Currency currency = new Currency(String.valueOf(id), nameOfCurrency, code);
        currenciesMap.put(code, currency);
    }

    public void updateRate(String currencyCode, double rateValue) {
        Currency currency = currenciesMap.get(currencyCode);
        if (currency != null) {
            Rate rate = new Rate(currency, rateValue);
            currenciesRate.put(currencyCode, rate);
            history.compute(currencyCode, (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(rate);
                return v;
            });
        } else {
            System.out.println("Валюта не найдена: " + currencyCode);
        }
    }
}
