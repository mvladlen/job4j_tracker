package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        System.out.println("=== Edit an Item ====");
        return null;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            System.out.println("Item replaced");                        // вывод об успешности операции
        } else {
            System.out.println("Item not replaced");                    // вывод об ошибке
        }
        return true;
    }
}
