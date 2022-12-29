package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель для банковской системы.
 * В системе можно производить следующие действия.
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводит деньги с одного банковского счета на другой счет.
 *
 * @author KOLLEGOV DMITRIY
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных осуществляется в коллекции типа HashMap.
     * Карта содержит всех пользователей системы с привязанными к ним счетами.
     * Ключом является объекты типа User.
     * Данные об аккаунтах объекта User храняться в коллекции типа ArrayList и имеют тип Account.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет в систему пользователя.
     * Метод к объекту User добавляет пустой список - new ArrayList<Account>().
     * Если при добавлении объекта класса User в нашем списке имеется этот объект, то метод нового user не добавляет.
     *
     * @param user объект класса User.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет удалять пользователя из системы, объкт класса User.
     *
     * @param passport поле класса User, уникально идентифицирует объект класса User.
     * @return возвращает true если объект класса User был удален.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет пользователю новый банковский счет, объект класса Account.
     * Если пользователь не найден или пользователь имеет данный счет, то счет не добавляется.
     *
     * @param passport поле класса User, уникально идентифицирует объект класса User.
     * @param account  объект класса Account, описывает новый счет пользователя.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод находит пользователя, объект класса User по данным паспорта, поля класса User passport.
     *
     * @param passport поле класса User, уникально идентифицирует объект класса User.
     * @return возвращает найденый объект класса User. Если пользователь не найден возвращает null.
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(f -> f.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод находит объект класса Account, принадлежащий объекту класса User.
     *
     * @param passport  поле класса User, уникально идентифицирует объект класса User.
     * @param requisite поле класса Account, содержит реквизиты объекта класса.
     * @return возвращает найденый объект класса Account. Если реквизиты не найдены возвращает null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            return list.stream()
                    .filter(f -> f.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод переводит деньги с одного банковского счета на другой счет.     *
     *
     * @param srcPassport   паспортные данные пользователя у которого переводят деньги.
     * @param srcRequisite  реквизиты аккаунта с которого переводят деньги.
     * @param destPassport  паспортные данные пользователя которому переводят деньги.
     * @param destRequisite реквизиты аккаунта на который переводят деньги.
     * @param amount        сумма перевода.
     * @return возвращает true если перевод прошел успешно. Если счёт не найден или не хватает денег на счёте
     * (с которого переводят), то метод возвращает false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Служебный метод, используется для проверки тестов.
     *
     * @param user принимает объект класса User.
     * @return возвращает коллекцию аккаунтов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
