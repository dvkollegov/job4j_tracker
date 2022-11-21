package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double divide(int a) {
        return a / x;
    }

    public double sumAllOperation(int sum) {
        return sum(sum) + minus(sum) + multiply(sum) + divide(sum);
    }

    public static void main(String[] args) {
        int sum = sum(10);
        System.out.println(sum);
        int minus  = minus(50);
        System.out.println(minus);
        Calculator calculator = new Calculator();
        int multiply = calculator.multiply(5);
        System.out.println(multiply);
        double divide = calculator.divide(10);
        System.out.println(divide);
        double sumAllOperation = calculator.sumAllOperation(50);
        System.out.println(sumAllOperation);
    }
}
