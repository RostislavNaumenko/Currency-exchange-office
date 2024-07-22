
## Проект "Обменный пункт валюты"

### Описание проекта:
### Разработать консольное приложение для имитации работы обменного пункта валюты.

Пользователи могут:
- регистрировать аккаунты,
- открывать счета в различных валютах (_в приложении должна быть поддержка минимум 3 валют_),
- пополнять счета,
- снимать средства со счетов,
- закрывать счета,
- осуществлять обмен валюты (_например, перевод с EUR счета на USD счет с конвертацией по курсу_),
- а также просматривать историю своих операций.

## Техническое задание:

1. **Многослойная архитектура приложения:**
    - **Модель (Model):** Определить сущности, такие как пользователь, аккаунт, операция, валюта, курс валюты и / или другие необходимые объекты.
    - **Сервис (Service):** Разработать бизнес-логику приложения, включая управление данными пользователей, выполнение валютных операций и т.д.
    - **Репозиторий (Repository):** Создать слой для взаимодействия с хранилищем данных (например, в памяти или файле(-ах)).

2. **Организация данных и управление аккаунтами:**
    - Реализовать механизмы для управления данными пользователя, включая их аккаунты и ведение счетов.
    - У пользователя могут быть счета минимум в 3 разных валютах.

3. **Управление валютными операциями:**
    - Обеспечить функциональность для осуществления валютных операций, включая пополнение, обмен и просмотр истории операций.

4. **Валидация данных:**
    - При регистрации нового пользователя реализовать валидацию введенного email и пароля. Валидация должна убедиться, что email соответствует стандартному формату электронной почты, а пароль соответствует заданным критериям безопасности (например, минимальная длина, наличие букв и цифр).

5. **Пользовательский интерфейс:**
    - Реализовать консольное меню для доступа к функциональности приложения.

6. **Тестирование:**
    - Разработать JUnit тесты для проверки всех аспектов функциональности приложения, особое внимание уделить тестированию сервисного слоя.

7. **Использование коллекции Map:**
    - В процессе разработки приложения активно использовать коллекцию `Map` для организации и управления данными, такими как учетные записи пользователей, счета, курсы валют и другие подходящие сценарии.
    - Например:
        - Для хранения списка аккаунтов пользователя, где ключом будет идентификатор пользователя, а значением - список его аккаунтов.
        - Для хранения курсов валют, где ключом будет код валюты, а значением - текущий курс.
        - Для хранения списка пользователей, где ключом будет id, а значением - пользователь.

8. **Разделение функциональности по ролям**
   - Пользователь с ролью **администратор** может, например:
     - Менять курс валюты
     - Изменять роль пользователя
     - Просматривать историю операций пользователей (опционально)
     - Блокировать пользователя (опционально)

9. **Исключения:**
   - В случае невозможности выполнить запрашиваемую пользователем операцию, должно быть выброшено соответсвующее исключение (обработать в слое `view` и выдать сообщение о природе ошибки пользователю)

**Опционально:**
- Возможность сохранения и загрузки данных пользователя (запись / чтение в файл(-ы).
- В случае провала валидации, приложение должно выбрасывать исключение, которое затем должно быть корректно обработано. Это может включать информирование пользователя о причине ошибки и предложение повторить попытку ввода данных.
- Функционал для просмотра исторических курсов валют.



<details style="margin-top: 16px">
  <summary style="cursor: pointer; color: green;"><b>English</b></summary>

## "Currency Exchange Office" Project

**Project Description:**
Develop a console application to simulate a currency exchange office operation. Users can register accounts, open accounts in various currencies, deposit funds, withdraw funds, perform currency exchanges, and view their transaction history.

**Technical Specification:**

1. **Multi-Layer Application Architecture:**
    - **Model (Model):** Define entities such as user, account, transaction, currency, exchange rate, and other necessary objects.
    - **Service (Service):** Develop the business logic of the application, including managing user data, executing currency operations, etc.
    - **Repository (Repository):** Create a layer for interaction with the data storage (e.g., in-memory or file(s)).

2. **Data Organization and Account Management:**
    - Implement mechanisms for managing user data, including their accounts and ledgers.
    - A user should have accounts in at least 3 different currencies.

3. **Currency Operation Management:**
    - Provide functionality for carrying out currency operations, including deposits, exchanges, and viewing transaction history.

4. **Data Validation:**
    - When registering a new user, implement validation for the entered email and password. Validation should ensure the email conforms to the standard email format, and the password meets set security criteria (e.g., minimum length, presence of letters and numbers).

5. **User Interface:**
    - Implement a console menu for accessing the application's functionality.

6. **Testing:**
    - Develop JUnit tests to check all aspects of the application's functionality, with special attention to testing the service layer.

7. **Using the Map Collection:**
    - Actively use the `Map` collection for organizing and managing data, such as user accounts, accounts, exchange rates, and other suitable scenarios during application development.
    - For example:
        - To store a list of a user's accounts, where the key is the user ID, and the value is a list of their accounts.
        - To store exchange rates, where the key is the currency code, and the value is the current rate.

**Optional:**
- The ability to save and load user data.
- In case of validation failure, the application should throw an exception, which should then be properly handled. This may include informing the user of the reason for the error and offering to retry entering data.
- Functionality to view historical exchange rates.

</details>