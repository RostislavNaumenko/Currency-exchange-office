package repository;

import model.Account;
import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    // Map для хранения пользователей: ключ - ID пользователя, значение - объект User
    private Map<Integer, User> users = new HashMap<>();
}
