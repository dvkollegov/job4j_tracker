package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка.
 * @author KOLLEGOV DMITRIY
 * @version 1.0
 */
public class User {
    /**
     * Поле класса passport уникально идентифицирует пользователя.
     */
    private String passport;
    /**
     * Поле класса username задает имя пользователя.
     */
    private String username;

    /**
     * Констуктор класса. При создании объекта класса User требуется инициализация полей класса passport и username.
     * @param passport описываются данные паспорта пользователя.
     * @param username задается имя пользователя.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер поля passport объекта User.
     * @return возвращает значение passport.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер поля passport объекта User.
     * @param passport задает значение passport.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер поля username объекта User.
     * @return возвращает значение username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер поля username объекта User.
     * @param username задает значение username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод equals объекта класса User.
     * @param o принимает объект класса User.
     * @return возвращает true если сравниваемые объекты типа User равны по полям passport.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метод hashCode объекта класса User.
     * @return возвращает целочисленное значение объекта класса User.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
