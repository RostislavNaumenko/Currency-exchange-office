package view;

import model.Account;
import model.User;
import service.AccountService;
import service.TransactionService;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserMenu {
    private final UserService userService;
    private final TransactionService transactionService;
    private final AccountService accountService;
    private final Scanner scanner = new Scanner(System.in);

    public UserMenu(UserService userService, TransactionService transactionService, AccountService accountService) {
        this.userService = userService;
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    public void showUserMenu() {
        while (true) {
            System.out.println("МЕНЮ ПОЛЬЗОВАТЕЛЯ");
            System.out.println("1 -> Информация о пользователе");
            System.out.println("2 -> Просмотр аккаунта");
            System.out.println("3 -> Переводы");
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
                break;
            case 2:
                viewAccount();
                break;
            case 3:
                showTransferMenu();
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

        User activeUser = userService.getActiveUser();
        List<Account> accounts = accountService.getAccountsByUserId(activeUser.getId());

        System.out.println("Ваши аккаунты:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + " -> " + accounts.get(i));
        }

        System.out.println("Выберите аккаунт для списания средств:");
        int fromIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Выберите аккаунт для зачисления средств:");
        int toIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите сумму перевода:");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Account fromAccount = accounts.get(fromIndex);
        Account toAccount = accounts.get(toIndex);

    }

    private void makeExternalTransfer() {
        System.out.println("Перевод на другой аккаунт");

        User activeUser = userService.getActiveUser();
        List<Account> accounts = accountService.getAccountsByUserId(activeUser.getId());

        System.out.println("Ваши аккаунты:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + " -> " + accounts.get(i));
        }

        System.out.println("Выберите аккаунт для списания средств:");
        int fromIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите email пользователя, которому вы хотите перевести средства:");
        String email = scanner.nextLine();
        User recipient = userService.getUserByEmail(email);

        if (recipient == null) {
            System.out.println("Пользователь с таким email не найден.");
            return;
        }

        List<Account> recipientAccounts = accountService.getAccountsByUserId(recipient.getId());
        System.out.println("Аккаунты получателя:");
        for (int i = 0; i < recipientAccounts.size(); i++) {
            System.out.println(i + " -> " + recipientAccounts.get(i));
        }

        System.out.println("Выберите аккаунт для зачисления средств:");
        int toIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите сумму перевода:");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Account fromAccount = accounts.get(fromIndex);
        Account toAccount = recipientAccounts.get(toIndex);

    }

    private void viewAccount() {
        System.out.println("Просмотр аккаунта");

        User activeUser = userService.getActiveUser();
        List<Account> accounts = accountService.getAccountsByUserId(activeUser.getId());

        System.out.println("Ваши аккаунты:");
        for (Account account : accounts) {
            System.out.println(account);
        }

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
                break;
            case 2:
                //вывести все аккаунты, передать id  метод с accountService
                break;
            default:
                System.out.println("Некорректный выбор\n");
        }
    }

}
