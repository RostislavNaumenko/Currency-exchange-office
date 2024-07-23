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
        final Menu menu = new Menu();
        UserRepository userRepository = new UserRepository();
        CurrencyRepository currencyRepository = new CurrencyRepository();
        TransactionRepository transactionRepository = new TransactionRepository();

        UserService userService = new UserService();
        CurrencyService currencyService = new CurrencyService();
        TransactionService transactionService = new TransactionService();
        menu.run();

    }
}
