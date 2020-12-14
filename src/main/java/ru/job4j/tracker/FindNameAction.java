package ru.job4j.tracker;

public class FindNameAction implements UserAction {

    @Override
    public String name() {
        System.out.println("=== Find an Item by name ===");
        return null;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) System.out.println(item);
        } else System.out.println("Заявки с таким name не найдены");
        return true;
    }
}
