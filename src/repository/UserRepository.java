package repository;

import model.Role;
import model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {
    // Map для хранения пользователей: ключ - ID пользователя, значение - объект User
    private Map<Integer, User> users = new HashMap<>();
    private final AtomicInteger currentId = new AtomicInteger(1);


    public User addUser(String email, String password, String name, String surname){
        User user = new User(currentId.getAndIncrement(), email, password, name, surname);
        users.put(user.getId(), user);
        return user;
    }

    public User getUserByEmail(String email){
        return users.values().stream()
                .filter(user1 -> user1.getEmail().equals(email))
                .findFirst()
                .orElse(null);

    }

    public User setUserRole(int id, Role role){
        User user = getUserById(id);
        if(user == null) return null;
        user.setRole(role);

        return user;
    }

    public User getUserById(Integer id) {
        return users.get(id);
    }

    public Map<Integer, User> getAllUsers() {
        return users;
    }

    public boolean isEmailExists(String email) {
        return users.values().stream()
                .anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }

}
