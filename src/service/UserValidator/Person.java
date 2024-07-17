package service.UserValidator;

public class Person {
    private String email;
    private String password;

    public Person(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        try {
            PersonValidator.validateEmail(email);
            System.out.println("Email прошел проверку успешно!");
            this.email = email;
        } catch (EmailValidateException e) {
            System.out.println("Вы ввели некорректный email: " + e.getMessage());
//            e.printStackTrace();
        }
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            PersonValidator.validatePassword(password);
            System.out.println("Password прошел проверку успешно!");
            this.password = password;
        } catch (PasswordValidateException e) {
            System.out.println("Вы ввели некорректный пароль: " + e.getMessage());
        }


    }
    /*
    Требования к паролю
    1. длина >= 8
    2. должна быть мин 1 цифра
    3. должна быть мин 1 маленькая буква
    4. должна быть мин 1 большая буква
    5. должна быть мин 1 спец.символ ("!%$@&*()[]")
     */

    private boolean isPasswordValid(String password) {
        if (password == null || password.length() < 8) return false;

        boolean isDigit = false;
        boolean isLowerCase = false;
        boolean isUpperCase = false;
        boolean isSpecialSymbol = false;

        // альтернативный способ объявления переменных
        boolean[] res = new boolean[4]; // false, false, false, false

        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                isDigit = true;
//                res[0] = true;
            }

            if (Character.isLowerCase(ch)) {
                isLowerCase = true;
//                res[1] = true;
            }

            if (Character.isUpperCase(ch)) {
                isUpperCase = true;
//                res[2] = true;
            }

            if ("!%$@&*()[]".indexOf(ch) >= 0) {
                isSpecialSymbol = true;
//                res[3] = true;
            }


        }

        //true      true
        return isDigit && isLowerCase && isUpperCase && isSpecialSymbol;

//        return res[0] && res[1] && res[2] && res[3];

    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                '}';
    }
}