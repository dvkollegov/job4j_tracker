package ru.job4j.oop;

public class Car implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по шоссе");
    }

    @Override
    public void fuelGrade() {
        System.out.println(getClass().getSimpleName() + " использует АИ-92");
    }

}
