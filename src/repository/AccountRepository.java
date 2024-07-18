package repository;

import model.Account;
import model.Transaction;

import java.util.List;
import java.util.Map;

public class AccountRepository {
    // Map для хранения аккаунтов пользователей: ключ - ID пользователя, значение - список аккаунтов пользователя
    Map<Integer, List<Account>> accounts;
    // Map для хранения транзакций аккаунта: ключ - ID аккаунта, значение - список транзакций аккаунта
    Map<Integer, List<Transaction>> accountsTransactions;
}
