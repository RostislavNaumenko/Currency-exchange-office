package service.test;

import model.Role;
import model.User;
import org.junit.jupiter.api.Test;
import service.UserService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    public void testRegisterUser() {
        UserService userService = new UserService();

        // Тест регистрации
        User user1 = userService.registerUser("test@example.com", "Password123!", "John", "Doe");
        assertNotNull(user1);
        assertEquals("test@example.com", user1.getEmail());
        assertEquals("John", user1.getName());
        assertEquals("Doe", user1.getSurname());

        // Тест регистрации с невалидным email
        User user2 = userService.registerUser("invalid_email", "Password123!", "Jane", "Smith");
        assertNull(user2);

        // Тест регистрации с невалидным паролем
        User user3 = userService.registerUser("test2@example.com", "weak", "Bob", "Johnson");
        assertNull(user3);

        // Тест регистрации с существующим email
        User user4 = userService.registerUser("test@example.com", "Password456!", "Alice", "Williams");
        assertNull(user4);

    }

    @Test
    public void testAuthenticate() {
        UserService userService = new UserService();

        // Тест успешной аутентификации
        userService.registerUser("test@example.com", "Password123!", "John", "Doe");
        boolean isAuthenticated = userService.authenticate("test@example.com", "Password123!");
        assertTrue(isAuthenticated);


        // Тест аутентификации с неверным email
        isAuthenticated = userService.authenticate("wrong@example.com", "Password123!");
        assertFalse(isAuthenticated);

        // Тест аутентификации с неверным паролем
        isAuthenticated = userService.authenticate("test@example.com", "WrongPassword");
        assertFalse(isAuthenticated);
    }

    // тест админа

    @Test
    public void testAdminMethods() {
        UserService userService = new UserService();

        // Регистрация
        User admin = userService.registerUser("admin@example.com", "AdminPassword123!", "Admin", "User");
        admin.setRole(Role.ADMIN);
        User user1 = userService.registerUser("user1@example.com", "User1Password123!", "Userr", "Doe");
        User user2 = userService.registerUser("user2@example.com", "User2Password123!", "Usern", "Smith");

        // Тест получения пользователя по email
        User retrievedUser = userService.getUserByEmail("user1@example.com");
        assertEquals(user1, retrievedUser);

        // Тест получения пользователя по id
        retrievedUser = userService.getUserById(user2.getId());
        assertEquals(user2, retrievedUser);

        // Тест получения всех пользователей (только для администратора)
        Map<Integer, User> allUsers = userService.getAllUsers();
        assertNotNull(allUsers);
        assertEquals(3, allUsers.size());

        // Тест изменения роли пользователя (только для администратора)
        User updatedUser = userService.setUserRole(user1.getId(), Role.ADMIN);
        assertEquals(Role.ADMIN, updatedUser.getRole());
    }


}
