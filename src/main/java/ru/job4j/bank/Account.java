package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета пользователя.
 * @author KOLLEGOV DMITRIY
 * @version 1.0
 */
public class Account {
    /**
     * Поле класса requisite описывает реквизиты банковского счета.
     */
    private String requisite;
    /**
     * Поле класса balance содержит количество денежных средств.
     */
    private double balance;

    /**
     * Констуктор класса. При создании объекта класса Account требуется инициализация полей класса requisite и balance.
     * @param requisite описывает реквизиты банковского счета.
     * @param balance задается количество денежных средств.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер поля requisite объекта Account.
     * @return возвращает значение requisite.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер поля requisite объекта Account.
     * @param requisite задает значение requisite.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер поля balance объекта Account.
     * @return возвращает значение balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер поля requisite объекта Account.
     * @param balance задает значение balance.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод equals объекта класса Account.
     * @param o принимает объект класса Account.
     * @return возвращает true если сравниваемые объекты типа Account равны по полям requisite.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод hashCode объекта класса Account.
     * @return возвращает целочисленное значение объекта класса Account.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
