package service.CurrencyServiceTests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.CurrencyService;

public class CurrencyServiceParameterizedTest {
    @ParameterizedTest
    @ValueSource(strings = {"USD", "EUR", "GBP", "PLN", "CZK"})
    public void testValidCurrencies(String currency) {
        CurrencyService currencyService = new CurrencyService();
        // Здесь проверьте, что метод корректно обрабатывает разные валюты
        // (например, проверьте, что обмен USD -> EUR дает ожидаемый результат)
    }
}