package service.CurrencyServiceTests;

import model.Currency;
import model.Rate;
import org.junit.jupiter.api.Test;
import service.CurrencyService;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CurrencyServiceTest {



    @Test
    public void testGetCurrencyByCode() {
        CurrencyService currencyService = new CurrencyService();
        Currency currency = currencyService.getCurrencyByCode("USD");
        assertNotNull(currency);
        assertEquals("USD", currency.getCode());
    }

    @Test
    public void testEmptyRateHistories() {
        CurrencyService currencyService = new CurrencyService();
        Map<String, List<Rate>> result = currencyService.getAllRateHistories();
        // Здесь проверьте, что результат пустой (например, result.isEmpty())
        assertTrue(result.isEmpty());
    }

    @Test
    public void testAddCurrency() {
        CurrencyService currencyService = new CurrencyService();
        currencyService.addCurrency("Euro", "EUR");
        // Здесь проверьте, что валюта успешно добавлена
        assertTrue(currencyService.getAllCurrentRates().containsKey("EUR"));
    }

    @Test
    public void testUpdateRate() {
        CurrencyService currencyService = new CurrencyService();
        currencyService.addCurrency("Dollar", "USD");
        currencyService.updateRate("USD", 1.2);
        // Здесь проверьте, что курс успешно обновлен
        assertEquals(1.2, currencyService.getAllCurrentRates().get("USD").getRate(), 0.01);
    }

    @Test
    public void testGetAllCurrencies() {
        CurrencyService currencyService = new CurrencyService();
        Map<String, Currency> result = currencyService.getAllCurrencies();
        // Здесь проверьте, что результат не равен null и содержит ожидаемые данные
        assertNotNull(result);
        // Подставляем ожидаемые значения для валют
        assertTrue(result.containsKey("USD"));
        assertTrue(result.containsKey("EUR"));
        assertTrue(result.containsKey("GBP"));
        assertTrue(result.containsKey("PLN"));
        assertTrue(result.containsKey("CZK"));

    }


}

