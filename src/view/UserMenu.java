package view;

import service.TransactionService;
import service.UserService;
import java.util.Scanner;

public class UserMenu {
    private final UserService userService;
    private final TransactionService transactionService;
    private final Scanner scanner = new Scanner(System.in);

    public UserMenu(UserService userService, TransactionService transactionService) {
        this.userService = userService;
        this.transactionService = transactionService;
    }

    public void showUserMenu() {
        while (true) {
            System.out.println("МЕНЮ ПОЛЬЗОВАТЕЛЯ");
            System.out.println("1 -> Информация о пользователе");
            System.out.println("2 -> Сделать перевод валюты");
            System.out.println("3 -> История транзакций");
            System.out.println("0 -> Возврат в предыдущее меню");

            System.out.println("\nСделайте выбор пункта:");

            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 0)
                break;

            handleUserMenuChoice(input);
        }
    }

    private void handleUserMenuChoice(int input) {
        switch (input) {
            case 1:
                System.out.println("\nВаша информация: \n");
                System.out.println(userService.getActiveUser());
                waitRead();
                break;
            case 2:
                makeCurrencyTransfer();
                break;
            case 3:
                showTransactionHistory();
                break;
            default:
                System.out.println("Некорректный выбор\n");
        }
    }

    private void makeCurrencyTransfer() {
        System.out.println("СДЕЛАТЬ ПЕРЕВОД ВАЛЮТЫ");
        //Todo Нужен ли нам перевод валюты?
    }

    private void showTransactionHistory() {
        System.out.println("ИСТОРИЯ ТРАНЗАКЦИЙ");
        //Todo отображение истории транзакций
    }

    public void waitRead() {
        System.out.println("\nДля продолжения нажмите Enter ");
        scanner.nextLine();
    }
}
