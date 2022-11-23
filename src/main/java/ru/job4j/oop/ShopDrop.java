package ru.job4j.oop;

public class ShopDrop {

    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index; i < products.length; i++) {
            for (int j = i + 1; j < products.length; j++) {
                if (products[j] != null) {
                    products[i] = products[j];
                    products[j] = null;
                    break;
                }
            }
        }
        return products;
    }
}
