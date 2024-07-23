package view;

import service.AccountService;
import service.TransactionService;
import service.UserService;
import java.util.Scanner;

public class UserMenu {
    private final UserService userService;
    private final AccountService accountService;
    private final TransactionService transactionService;
    private final Scanner scanner = new Scanner(System.in);

    public UserMenu(UserService userService, AccountService accountService, TransactionService transactionService) {
        this.userService = userService;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    public void showUserMenu() {
        while (true) {
            System.out.println("МЕНЮ ПОЛЬЗОВАТЕЛЯ");
            System.out.println("1 -> Информация о пользователе");
            System.out.println("2 -> Переводы");
            System.out.println("3 -> Просмотр аккаунта");
            System.out.println("4 -> История транзакций");
            System.out.println("0 -> Выход");

            System.out.println("\nСделайте выбор пункта:");

            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 0){
                System.out.println("До свидания");
                userService.logout();
                break;

            }

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
        //Добавить вывод своих аккаунтов
        //Выбрать с какого аккаунта на какой аккаунт сделать перевод
        //Узнать сумму
        System.out.println("1 -> Перевод между своими счетами");
        System.out.println("2 -> Перевод на другой аккаунт");
        //Узнать email кому отправить и вывести его аккаунты
        //ввести аккаунт на какой переводить
        //Добавить вывод своих аккаунтов
        //Выбрать с какого аккаунта на какой аккаунт сделать перевод
        //Узнать сумму
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
                //передать User, и вызвать метод с accountService
                showAllUserTransactions();
                break;
            case 2:
                //вывести все аккаунты, передать id  метод с accountService
                showAccountTransactions();
                break;
            default:
                System.out.println("Некорректный выбор\n");
        }
    }
    //Удалить
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
