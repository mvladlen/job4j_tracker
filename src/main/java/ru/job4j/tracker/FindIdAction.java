package ru.job4j.tracker;

public class FindIdAction implements UserAction {
    private final Output out;

    public FindIdAction(Output out) {
        this.out = out;
    }


    @Override
    public String name() {
        return "=== Find an Item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item.toString());
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
