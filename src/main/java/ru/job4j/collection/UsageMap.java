package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("oumby@mailto.plus", "Ivanov Andrey");
        map.put("xdogu@mailto.plus", "Petrov Semen");
        map.put("nzaeu@mailto.plus", "Shishkin Ivan");
        for (String key : map.keySet()) {
            String name = map.get(key);
            System.out.println(key + " - " + name);
        }
    }
}
