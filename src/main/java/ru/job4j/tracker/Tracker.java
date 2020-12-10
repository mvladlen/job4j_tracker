package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] clearedItems = new Item[size];
        int filled = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                clearedItems[filled] = items[i];
                filled++;
            }
        }
        clearedItems = Arrays.copyOf(clearedItems, filled);
        return clearedItems;
    }

    public Item[] findByName(String key) {
        Item[] clearedItems = new Item[size];
        int filled = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                clearedItems[filled] = items[i];
                filled++;
            }
        }
        clearedItems = Arrays.copyOf(clearedItems, filled);
        return clearedItems;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        } else
            items[index] = item;
        items[index].setId(id);
        return true;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        System.arraycopy(items, index, items, index + 1, size - index - 1);
        items[size - 1] = null;
        size--;
        return true;
    }
}