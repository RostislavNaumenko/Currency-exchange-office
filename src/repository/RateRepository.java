package repository;

import model.Rate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RateRepository {
    // Map для хранения текущего курса валют: ключ - ID валюты, значение - текущий курс
    private Map<String, Rate> currenciesRate = new HashMap<>();

}
