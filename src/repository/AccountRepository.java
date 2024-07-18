package repository;

import model.Account;
import model.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {
    // Map для хранения аккаунтов пользователей: ключ - ID пользователя, значение - список аккаунтов пользователя
    private Map<Integer, List<Account>> userAccountsMap = new HashMap<>();

    // Map для хранения транзакций аккаунта: ключ - ID аккаунта, значение - список транзакций аккаунта
    Map<Integer, List<Transaction>> accountsTransactions;
}
