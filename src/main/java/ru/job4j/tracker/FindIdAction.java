package ru.job4j.tracker;

public class FindIdAction implements UserAction {

    @Override
    public String name() {
        return "=== Find an Item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
