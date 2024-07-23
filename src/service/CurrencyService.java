package service;

import model.Currency;
import model.Rate;
import repository.CurrencyRepository;

import java.util.List;
import java.util.Map;

public class CurrencyService {
    private CurrencyRepository currencyRepository = new CurrencyRepository();

    //Получение валюты по коду
    public Currency getCurrencyByCode(String currencyCode) {
        return currencyRepository.getCurrencyByCode(currencyCode);
    }

    // Получение текущего курса валюты по коду
    public Rate getRateForCurrency(String currencyCode) {
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
    public List<Currency> getAllCurrencies() {
        return currencyRepository.getCurrenciesMap();
    }

    // Получение всех историй курсов валют
    public Map<String, List<Rate>> getAllRateHistories() {
        return currencyRepository.getHistory();
    }


}
