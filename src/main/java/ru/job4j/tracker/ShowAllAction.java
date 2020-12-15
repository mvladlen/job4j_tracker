package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    @Override
    public String name() {
        return "=== List of Items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        tracker.showAll();
        return true;
    }
}
