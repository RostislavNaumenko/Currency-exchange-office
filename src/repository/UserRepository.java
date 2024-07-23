package repository;

import model.Role;
import model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class UserRepository {
    // Map для хранения пользователей: ключ - ID пользователя, значение - объект User
    private Map<Integer, User> users = new HashMap<>();
    private final AtomicInteger currentId = new AtomicInteger(1);

    private void initUsersTestData() {

        User admin = new User(currentId.getAndIncrement(), "1", "1", "1", "1");
        admin.setRole(Role.ADMIN);
        List<User> userList = new ArrayList<>();
        userList.addAll(new ArrayList<>(List.of(
                new User(currentId.getAndIncrement(), "test@email.net", "qwerty!Q1", "Vitan", "Volys"),
                new User(currentId.getAndIncrement(), "admin@email.net", "admin!Q1", "Oleksandr", "Petrov"),
                new User(currentId.getAndIncrement(), "user2@email.net", "qwerty!Q1", "Rosty", "Basko"),
                new User(currentId.getAndIncrement(), "user3@email.net", "qwerty!Q1", "Olga", "Tur"),
                new User(currentId.getAndIncrement(), "2", "2", "2", "2"),
                admin

        )));
    }

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

    public List<User> getAllUsers() {
        return users.values().stream().collect(Collectors.toList());
    }

    public boolean isEmailExists(String email) {
        return users.values().stream()
                .anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }

}
