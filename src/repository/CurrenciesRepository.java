package repository;

import model.Currency;
import model.Rate;

import java.util.List;
import java.util.Map;

public class CurrenciesRepository {
    Map<String, Rate> currenciesRate;

    Map<String, Currency>  currenciesMap;
    // валюта     история курса
    Map<String, List<Rate>> history;
}
