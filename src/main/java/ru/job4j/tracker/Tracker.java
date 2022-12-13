package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> itemsList = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        itemsList.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? itemsList.get(index) : null;
    }

    public List<Item> findAll() {
        return itemsList;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : itemsList) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item item : itemsList) {
            if (item.getId() == id) {
                rsl = itemsList.indexOf(item);
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rls = index != -1;
        if (rls) {
            item.setId(id);
            itemsList.set(index, item);
        }
        return rls;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rls = index != -1;
        if (rls) {
            itemsList.remove(index);
        }
        return rls;
    }
}