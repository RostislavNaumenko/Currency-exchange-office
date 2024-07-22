package view;

import java.util.Scanner;

public class Menu {
    private final UserMenu userMenu;
    private final AdminMenu adminMenu;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(UserMenu userMenu, AdminMenu adminMenu) {
        this.userMenu = userMenu;
        this.adminMenu = adminMenu;
    }

    public void run() {
        showWelcomeMessage();
        showMainMenu();
    }

    private void showWelcomeMessage() {
        System.out.println("Быстрый обмен валюты");
        System.out.println("Быстрые и безопасные обмены для наших клиентов 24/7");
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("\nВыберите:");
            System.out.println("1 -> Меню администратора");
            System.out.println("2 -> Меню пользователя");
            System.out.println("0 -> Выход");
            System.out.println("\nСделайте выбор:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("До свидания");
                System.exit(0);
            }
            showSubMenu(choice);
        }
    }

    private void showSubMenu(int choice) {
        switch (choice) {
            case 1:
                adminMenu.showAdminMenu();
                break;
            case 2:
                userMenu.showUserMenu();
                break;
            default:
                System.out.println("Сделайте корректный выбор\n");
        }
    }
}