package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public ArrayList<Item> findAll() {
//        ArrayList<Item> clearedItems = new ArrayList<Item>();
        return this.items;
    }

    public void showAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(items.get(i).toString());
        }
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> clearedItems = new ArrayList<Item>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                clearedItems.add(item);
            }
        }
        return clearedItems;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int index = 0;
        for (Item item : items) {
            if (item.getId() == id) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        } else {
            items.remove(index);
            items.add(item);
        }
        items.get(index).setId(id);
        return true;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items.remove(index);
        size--;
        return true;
    }
}