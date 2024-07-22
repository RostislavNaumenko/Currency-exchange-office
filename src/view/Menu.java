package view;

import model.Role;
import model.User;
import service.UserService;

import java.util.Scanner;

public class Menu {

    private final UserService userService;
    private final UserMenu userMenu;
    private final AdminMenu adminMenu;


    private User activeUser;

    private final Scanner scanner = new Scanner(System.in);

    public Menu(UserMenu userMenu, AdminMenu adminMenu) {
        this.userService = new UserService();
        this.userMenu = userMenu;
        this.adminMenu = adminMenu;
    }

    public void run() {
        showAuthorizationMenu();
    }
    private void showAuthorizationMenu() {
        while (true) {
            System.out.println("\nДобро пожаловать в Библиотеку\n");
            System.out.println("1 -> Авторизация");
            System.out.println("2 -> Создать нового пользователя");
            System.out.println("0 -> Выход");
            System.out.println("\nСделайте выбор:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("До свидания");
                System.exit(0);

            }
            showAuthorizationSubMenu(choice);
        }
    }

    private void showAuthorizationSubMenu(int choice) {
        switch (choice) {
            case 1:
                System.out.println("АВТОРИЗАЦИЯ\n");
                System.out.println("Введите email: ");
                String email = scanner.nextLine();
                System.out.println("Введите password:");
                String password = scanner.nextLine();
                if( userService.authenticate(email,password)){
                    activeUser = userService.getActiveUser();
                    showMainMenu();

                }else {
                    System.out.println("Неправильный email или пароль");
                    waitRead();
                    break;
                }
            case 2:
                System.out.println("Создание нового пользователя\n");
                System.out.println("Введите имя: ");
                String newName = scanner.nextLine();
                System.out.println("Введите фамилию: ");
                String newSurname = scanner.nextLine();
                System.out.println("Введите email: ");
                String newEmail = scanner.nextLine();
                System.out.println("Введите password:");
                String newPassword = scanner.nextLine();
                User user = userService.registerUser(newEmail, newPassword, newName, newSurname);
                if(user == null){
                    System.out.println("Не корректные данные");
                    waitRead();
                    break;

                }else{
                    System.out.println("Пользователь зарегистрирован!");
                    activeUser = userService.getActiveUser();
                    showMainMenu();
                }
                break;

            default:
                System.out.println("Сделайте корректный выбор\n");

        }

    }

    private void showMainMenu(){
        if(activeUser.getRole().equals(Role.ADMIN)){
            while (true) {
                System.out.println("Добро пожаловать в меню\n");
                System.out.println("1 -> Меню администратора");
                System.out.println("2 -> Меню счетов");
                System.out.println("3 -> Меню пользователя");
                System.out.println("0 -> Выход");
                System.out.println("\nСделайте выбор:");

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 0) {
                    System.out.println("До свидания");
                    userService.logout();
                    System.exit(0);

                }
                //showSubMenuForAdmin(choice);
            }
        } else if (activeUser.getRole().equals(Role.USER)) {
            while (true) {
                System.out.println("Добро пожаловать в меню\n");
                System.out.println("2 -> Меню счетов");
                System.out.println("3 -> Меню пользователя");
                System.out.println("0 -> Выход");
                System.out.println("\nСделайте выбор:");

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 0) {
                    System.out.println("До свидания");
                    userService.logout();
                    System.exit(0);

                }
                //showSubMenuForUser(choice);
            }

        }
    }

    public void waitRead () {
        System.out.println("\nДля продолжения нажмите Enter ");
        scanner.nextLine();
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