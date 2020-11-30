package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public void Item()
    {

    }

    public void Item(int id) {
        this.id = id;
    }

    public void Item(int id, String name) {
        Item(id);
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}