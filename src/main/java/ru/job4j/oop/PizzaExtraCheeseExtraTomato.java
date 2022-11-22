package ru.job4j.oop;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    public String name() {
        return super.name() + " + " + "extra tomato";
    }
}
