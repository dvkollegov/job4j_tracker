package ru.job4j.oop;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        book1.setName("Clean code");
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.print(bk.getName() + " | ");
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.print(bk.getName() + " | ");
        }
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if (bk.getName() == "Clean code") {
                System.out.println(bk.getName());
            }
        }
    }
}
