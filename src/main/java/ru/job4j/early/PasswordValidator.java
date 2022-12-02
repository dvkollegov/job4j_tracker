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
        char[] array = password.toCharArray();
        int upperLetter = 0;
        int lowerLetter = 0;
        int digit = 0;
        int specialSymbol = 0;
        for (char c : array) {
            if (Character.isUpperCase(c)) {
                upperLetter++;
            }
            if (Character.isLowerCase(c)) {
                lowerLetter++;
            }
            if (Character.isDigit(c)) {
                digit++;
            }
            if (Character.isLetterOrDigit(c)) {
                specialSymbol++;
            }
        }
        if (upperLetter == 0) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (lowerLetter == 0) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (digit == 0) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (specialSymbol == array.length) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return password;
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
