package repository;

import model.Account;
import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    // Map для хранения аккаунтов пользователей: ключ - ID пользователя, значение - список аккаунтов пользователя
    private Map<String, List<Account>> userAccountsMap = new HashMap<>();

    // Map для хранения пользователей: ключ - ID пользователя, значение - объект User
    private Map<String, User> users = new HashMap<>();
}
