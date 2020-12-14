package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    @Override
    public String name() {
        System.out.println("=== List of Items ===");
        return null;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        tracker.showAll();
        return true;
    }
}
