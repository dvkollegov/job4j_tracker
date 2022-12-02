package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (isAbuseText(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        if (!isUpperLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!isLowerLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!isDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!isSpecialSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return password;
    }

    public static boolean isUpperLetter(String password) {
        char[] array = password.toCharArray();
        for (char c : array) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDigit(String password) {
        char[] array = password.toCharArray();
        for (char c : array) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLowerLetter(String password) {
        char[] array = password.toCharArray();
        for (char c : array) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSpecialSymbol(String password) {
        char[] array = password.toCharArray();
        int count = 0;
        for (char c : array) {
            if (Character.isLetterOrDigit(c)) {
                count++;
            }
        }
        return count < array.length;
    }

    public static boolean isAbuseText(String password) {
        String[] subtext = {"qwerty", "12345", "password", "admin", "user"};
        for (String s : subtext) {
            if (password.toLowerCase().contains(s)) {
                return true;
            }
        }
        return false;
    }
}
