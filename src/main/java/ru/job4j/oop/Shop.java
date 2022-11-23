package ru.job4j.oop;

public class Shop {

    public static int indexOfNull(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            Product pr = products[i];
            if (pr == null) {
                return i;
            }
        }
        return -1;
    }
}
