package repository;

import model.Currency;
import model.Rate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrencyRepository {
    // Map для хранения текущего курса валют: ключ - код валюты, значение - объект Rate
    Map<String, Rate> currenciesRate;
    // Map для хранения валют: ключ - code валюты, значение - объект Currency
    Map<String, Currency>  currenciesMap;
    // Map для хранения истории курсов валют: ключ - код валюты, значение - список курсов (Rate) для данной валюты
    Map<String, List<Rate>> history;

    public CurrencyRepository(Map<String, Rate> currenciesRate, Map<String, Currency> currenciesMap, Map<String, List<Rate>> history) {
        this.currenciesRate = currenciesRate;
        this.currenciesMap = currenciesMap;
        this.history = history;
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

    // добавления валюты
    public void addCurrency(Currency currency) {
        currenciesMap.put(currency.getCode(), currency);
    }

    // обновления текущего курса
    public void updateRate(String currencyCode, Rate rate) {
        currenciesRate.put(currencyCode, rate);
        history.computeIfAbsent(currencyCode, k -> new ArrayList<>()).add(rate);
    }
}

