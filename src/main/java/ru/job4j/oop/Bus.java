package ru.job4j.oop;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int number) {
        System.out.println("В автобусе " + number + " пассажиров");
    }

    @Override
    public double fuelCost(double fuel) {
        return fuel * 50;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.drive();
        bus.passengers(50);
        System.out.println(bus.fuelCost(25.6));
    }
}
