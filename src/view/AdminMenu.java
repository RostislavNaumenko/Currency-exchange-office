package view;

import service.CurrencyService;
import service.UserService;
import java.util.Scanner;

public class AdminMenu {
    private final CurrencyService currencyService;
    private final UserService userService;
    private final Scanner scanner = new Scanner(System.in);

    public AdminMenu(CurrencyService currencyService, UserService userService) {
        this.currencyService = currencyService;
        this.userService = userService;
    }

    public void showAdminMenu() {
        while (true) {
            System.out.println("МЕНЮ АДМИНИСТРАТОРА");
            System.out.println("1 -> Добавление валюты");
            System.out.println("2 -> Обновление курса валюты");
            System.out.println("3 -> Все валюты");
            System.out.println("4 -> Просмотр истории валют");
            System.out.println("5 -> Все пользователи");
            System.out.println("6 -> Сменить роль пользователю");
            System.out.println("0 -> Возврат в предыдущее меню");
            System.out.println("\nСделайте выбор пункта:");

            int control = scanner.nextInt();
            scanner.nextLine();

            if (control == 0)
                break;

            switch (control) {
                case 1:
                    addCurrencyWithRate();
                    break;
                case 2:
                    updateCurrencyRate();
                    break;
                case 3:
                    showAllCurrencies();
                    waitRead();
                    break;
                case 4:
                    showAllUsers();
                    waitRead();
                    break;
                case 5:
                    showCurrencyHistory();
                    waitRead();
                    break;
                default:
                    System.out.println("Некорректный выбор\n");
            }
        }
    }

    private void addCurrencyWithRate() {
        System.out.println("\nДОБАВЛЕНИЕ ВАЛЮТЫ");
        System.out.println("Введите название валюты: ");
        String name = scanner.nextLine();
        System.out.println("Введите код валюты: ");
        String code = scanner.nextLine();
        System.out.println("Введите курс валюты: ");
        double rate = scanner.nextDouble();
        scanner.nextLine();
        currencyService.addCurrency(name, code);
        currencyService.updateRate(code, rate);
        System.out.println("Валюта добавлена с курсом");
        waitRead();
    }

    private void updateCurrencyRate() {
        System.out.println("\nОБНОВЛЕНИЕ КУРСА ВАЛЮТЫ");
        System.out.println("Введите код валюты: ");
        String code = scanner.nextLine();
        System.out.println("Введите новый курс: ");
        double rate = scanner.nextDouble();
        scanner.nextLine();
        currencyService.updateRate(code, rate);
        System.out.println("Курс валюты обновлен");
        waitRead();
    }

    private void showAllCurrencies() {
        System.out.println(currencyService.getAllCurrencies());
    }

    private void showAllUsers() {
        System.out.println(userService.getAllUsers());
    }

    private void showCurrencyHistory() {
        System.out.println("\nИСТОРИЯ КУРСОВ ВАЛЮТ");
        System.out.println("Введите код валюты: ");
        String code = scanner.nextLine();
        System.out.println(currencyService.getRateHistory(code));
    }

    public void waitRead() {
        System.out.println("\nДля продолжения нажмите Enter ");
        scanner.nextLine();
    }
}
