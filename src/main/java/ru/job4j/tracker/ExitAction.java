package ru.job4j.tracker;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        System.out.println("Exit");
        return null;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
