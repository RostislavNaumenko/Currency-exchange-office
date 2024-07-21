package view;

import model.Role;
import model.User;
import repository.CurrencyRepository;
import repository.TransactionRepository;
import repository.UserRepository;
import service.CurrencyService;
import service.TransactionService;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        CurrencyRepository currencyRepository = new CurrencyRepository();
        TransactionRepository transactionRepository = new TransactionRepository();

        // создание сервисов
        UserService userService = new UserService();
        CurrencyService currencyService = new CurrencyService(currencyRepository);
        TransactionService transactionService = new TransactionService(transactionRepository);

        // регистрация пользователей
        User admin = new User(1, "admin@gmail.com", "Qwerty1!", "Admin", "User");
        admin.setRole(Role.ADMIN);

        User user = new User(2, "user@gmail.com", "Qwerty1!", "Regular", "User");
        user.setRole(Role.USER);

        // cоздание меню user и admin
        UserMenu userMenu = new UserMenu(userService, transactionService);
        AdminMenu adminMenu = new AdminMenu(currencyService, userService);

        // основное меню
        Menu menu = new Menu(userMenu, adminMenu);
        menu.run();
    }
}
