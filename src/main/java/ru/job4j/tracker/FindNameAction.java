package ru.job4j.tracker;

import java.util.ArrayList;

public class FindNameAction implements UserAction {
    private final Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }


    @Override
    public String name() {
        return "=== Find an Item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        ArrayList<Item> items = tracker.findByName(name);
        if (items != null) {
            for (Item item : items) out.println(item);
        } else out.println("Заявки с таким name не найдены");
        return true;
    }
}
