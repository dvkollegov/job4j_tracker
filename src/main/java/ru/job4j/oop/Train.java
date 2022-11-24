package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по рельсам");
    }

    @Override
    public void fuelGrade() {
        System.out.println(getClass().getSimpleName() + " использует электрический ток");
    }

}
