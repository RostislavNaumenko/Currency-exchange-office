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
            System.out.println("2 -> Переводы");
            System.out.println("3 -> Просмотр аккаунта");
            System.out.println("4 -> История транзакций");
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
                showTransferMenu();
                break;
            case 3:
                viewAccount();
                break;
            case 4:
                showTransactionHistoryMenu();
                break;
            default:
                System.out.println("Некорректный выбор\n");
        }
    }

    private void showTransferMenu() {
        System.out.println("ПЕРЕВОДЫ");
        System.out.println("1 -> Перевод между своими счетами");
        System.out.println("2 -> Перевод на другой аккаунт");
        System.out.println("0 -> Возврат в предыдущее меню");

        System.out.println("\nСделайте выбор пункта:");

        int input = scanner.nextInt();
        scanner.nextLine();
        if (input == 0)
            return;

        switch (input) {
            case 1:
                makeInternalTransfer();
                break;
            case 2:
                makeExternalTransfer();
                break;
            default:
                System.out.println("Некорректный выбор\n");
        }
    }

    private void makeInternalTransfer() {
        System.out.println("Перевод между своими счетами");
        waitRead();
    }

    private void makeExternalTransfer() {
        System.out.println("Перевод на другой аккаунт");
        waitRead();
    }

    private void viewAccount() {
        System.out.println("Просмотр аккаунта");
        waitRead();
    }

    private void showTransactionHistoryMenu() {
        System.out.println("ИСТОРИЯ ТРАНЗАКЦИЙ");
        System.out.println("1 -> Все транзакции");
        System.out.println("2 -> Транзакции по аккаунту");
        System.out.println("0 -> Возврат в предыдущее меню");

        System.out.println("\nСделайте выбор пункта:");

        int input = scanner.nextInt();
        scanner.nextLine();
        if (input == 0)
            return;

        switch (input) {
            case 1:
                showAllUserTransactions();
                break;
            case 2:
                showAccountTransactions();
                break;
            default:
                System.out.println("Некорректный выбор\n");
        }
    }

    private void showAllUserTransactions() {
        System.out.println("Все транзакции пользователя");
        waitRead();
    }

    private void showAccountTransactions() {
        System.out.println("Транзакции по аккаунту");
        waitRead();
    }

    public void waitRead() {
        System.out.println("\nДля продолжения нажмите Enter ");
        scanner.nextLine();
    }
}
