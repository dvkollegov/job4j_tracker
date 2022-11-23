package ru.job4j.oop;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Коллегов Дмитрий Вениаминович");
        student.setGroup("С-22");
        student.setDate(new Date());
        System.out.println("ФИО: " + student.getName() + ", группа: " + student.getGroup()
                           + ", дата поступления: " + student.getDate());
    }
}
