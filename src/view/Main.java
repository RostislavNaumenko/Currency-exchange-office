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

        UserService userService = new UserService();
        CurrencyService currencyService = new CurrencyService();
        TransactionService transactionService = new TransactionService();

        UserMenu userMenu = new UserMenu(userService, transactionService);
        AdminMenu adminMenu = new AdminMenu(currencyService, userService);

        Menu menu = new Menu(userMenu, adminMenu);
        menu.run();
    }
}
