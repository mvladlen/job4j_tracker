package ru.job4j.tracker;

import java.util.ArrayList;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }


    @Override
    public String name() {
        return "=== List of Items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        ArrayList<Item> items = tracker.findAll();
        for (Item item : items) {
            out.println(item.toString());
        }
        return true;
    }
}
