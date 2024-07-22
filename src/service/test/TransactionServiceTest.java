package service.test;

import model.Role;
import model.User;
import org.junit.jupiter.api.Test;
import service.UserService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    @Test
    public void testRegisterUser() {
        UserService userService = new UserService();

        // Тест успешной регистрации
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
        System.out.println("isAuthenticated : " + isAuthenticated);
        assertFalse(isAuthenticated);

        // Тест аутентификации с неверным паролем
        isAuthenticated = userService.authenticate("test@example.com", "WrongPassword");
        assertFalse(isAuthenticated);
    }


}


