package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Error active: " + active);
        System.out.println("Error status: " + status);
        System.out.println("Error message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error400 = new Error(true, 400, "bad request");
        Error error500 = new Error(true, 500, "Internal Server Error");
        error.printInfo();
        error400.printInfo();
        error500.printInfo();
    }
}