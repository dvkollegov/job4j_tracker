package ru.job4j.oop;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху");
    }

    @Override
    public void fuelGrade() {
        System.out.println(getClass().getSimpleName() + " использует авиационное топливо");
    }
}