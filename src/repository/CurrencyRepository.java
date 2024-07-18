package repository;

import model.Currency;
import model.Rate;

import java.util.List;
import java.util.Map;

public class CurrencyRepository {
    // Map для хранения текущего курса валют: ключ - код валюты, значение - объект Rate
    Map<String, Rate> currenciesRate;
    // Map для хранения валют: ключ - ID валюты, значение - объект Currency
    Map<String, Currency>  currenciesMap;
    // Map для хранения истории курсов валют: ключ - код валюты, значение - список курсов (Rate) для данной валюты
    Map<String, List<Rate>> history;
}
