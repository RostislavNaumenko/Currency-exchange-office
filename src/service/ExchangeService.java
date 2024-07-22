package service;

import model.*;

public class ExchangeService {
    private AccountService accountService = new AccountService();
    private CurrencyService currencyService = new CurrencyService();
    private TransactionService transactionService = new TransactionService();
/**
 * Метод для обмена валют между двумя аккаунтами.
 *
 * @param fromAccountId  ID аккаунта, с которого происходит списание.
 * @param toAccountId    ID аккаунта, на который происходит зачисление.
 * @param amount         Сумма для обмена.
 */

public void exchangeCurrency(int fromAccountId, int toAccountId, double amount) {

    // Получаем аккаунты
    Account fromAccount = accountService.getAccountById(fromAccountId);
    Account toAccount = accountService.getAccountById(toAccountId);

    // Проверяем, что аккаунты существуют
    if (fromAccount == null || toAccount == null) {
        throw new IllegalArgumentException("One or both accounts not found");
    }

    // Получаем валюты аккаунтов
    Currency fromCurrency = fromAccount.getCurrency();
    Currency toCurrency = toAccount.getCurrency();

    if(amount <= 0) {
        throw new IllegalArgumentException("Enter the correct amount of money");
    }


    // Проверяем наличие достаточного баланса на исходном аккаунте
    if (fromAccount.getBalance() < amount) {
        throw new IllegalArgumentException("Insufficient balance in fromAccount");
    }

    double withdrawAmount = amount;
    double takeAmount = amount;

    // Если валюты совпадают
    if (!fromCurrency.equals(toCurrency)) {
        // Конвертация валют
        Rate toRate = currencyService.getRateForCurrency(toCurrency.getCode());
        takeAmount = toRate.getRate() * amount;

    }

    // Отправитель
    Transaction withdrawTransaction = transactionService.createTransaction(toAccount, withdrawAmount, TransactionType.CREDIT, toCurrency);
    //Получатель
    Transaction debitTransaction = transactionService.createTransaction(fromAccount, takeAmount, TransactionType.DEBIT, fromCurrency);

    //Работа с account
    // Отправитель
    accountService.credit(fromAccountId, withdrawTransaction);
    //Получатель
    accountService.deposit(toAccountId, debitTransaction);


}

}
