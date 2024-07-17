package service.UserValidator;

public class PersonValidator {

    // throw = Ключевое слово используется для явного выброса исключения (создание объекта исключения)

    public static void validateEmail(String email) throws EmailValidateException {

        // 1. должна присутствовать @ и только одна
        int indexAt = email.indexOf('@');
        if (indexAt == -1 || indexAt != email.lastIndexOf('@')) throw new EmailValidateException("@ error");

        // 2. Точка после собаки
        if (email.indexOf('.', indexAt) == -1) throw new EmailValidateException(". after @ error");

        //3. после последней точки 2 или более символов
        if (email.lastIndexOf('.') >= email.length() - 2) throw new EmailValidateException("last . error");

        //4. английский алфавит, цифры, '_', '-', '.', '@'

        for (int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);

            if (!(Character.isAlphabetic(ch)
                    || Character.isDigit(ch)
                    || ch == '_'
                    || ch == '-'
                    || ch == '.'
                    || ch == '@')) {
                throw new EmailValidateException("illegal symbol");
            }
        }

        // 5. до собаки должен быть мин 1 символ
        // ???
        if (indexAt == 0) throw new EmailValidateException("@ should not first");

        if (!Character.isAlphabetic(email.charAt(0)))  throw new EmailValidateException("first symbol should be letter");

    }

    /* В email
    1. должна присутствовать @ и только одна (done)
    2. Точка после собаки (done)
    3. после последней точки 2 или более символов
    4. английский алфавит, цифры, '_', '-', '.', '@'
    5. до собаки должен быть мин 1 символ
     */

    public static void validatePassword(String password) throws PasswordValidateException {
        if (password == null || password.length() < 8) throw new PasswordValidateException("wrong length");

        boolean isDigit = false;
        boolean isLowerCase = false;
        boolean isUpperCase = false;
        boolean isSpecialSymbol = false;


        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                isDigit = true;
            }

            if (Character.isLowerCase(ch)) {
                isLowerCase = true;
            }

            if (Character.isUpperCase(ch)) {
                isUpperCase = true;
            }

            if ("!%$@&*()[]".indexOf(ch) >= 0) {
                isSpecialSymbol = true;
            }
        }

        if (!isDigit) throw new PasswordValidateException("should be a digit in password");
        if (!isLowerCase) throw new PasswordValidateException("should be a lower case letter in password");
        if (!isUpperCase) throw new PasswordValidateException("should be a upper case letter in password");
        if (!isSpecialSymbol) throw new PasswordValidateException("should be a special symbol in password");

    }
}