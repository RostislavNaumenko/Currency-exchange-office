package service;

import model.Currency;
import model.Rate;
import repository.CurrencyRepository;

import java.util.List;
import java.util.Map;

public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    // Получение текущего курса валюты по коду
    public Rate getCurrentRate(String currencyCode) {
        return currencyRepository.getRateForCurrency(currencyCode);
    }

    // Получение истории курсов валюты по коду
    public List<Rate> getRateHistory(String currencyCode) {
        return currencyRepository.getRateHistoryForCurrency(currencyCode);
    }

    // Добавление новой валюты
    public void addCurrency(String nameOfCurrency, String code) {
        currencyRepository.addCurrency(nameOfCurrency, code);
    }

    // Обновление текущего курса валюты
    public void updateRate(String currencyCode, double rateValue) {
        currencyRepository.updateRate(currencyCode, rateValue);
    }

    // Получение всех доступных валют и их курсов
    public Map<String, Rate> getAllCurrentRates() {
        return currencyRepository.getCurrenciesRate();
    }

    // Получение всех валют
    public Map<String, Currency> getAllCurrencies() {
        return currencyRepository.getCurrenciesMap();
    }

    // Получение всех историй курсов валют
    public Map<String, List<Rate>> getAllRateHistories() {
        return currencyRepository.getHistory();
    }
}