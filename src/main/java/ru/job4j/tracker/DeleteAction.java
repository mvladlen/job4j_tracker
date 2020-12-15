package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "=== Delete an Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            System.out.println("Item deleted");                        // вывод об успешности операции
        } else {
            System.out.println("Error. Item not deleted");                        // вывод об ошибке
        }
        return true;
    }
}
