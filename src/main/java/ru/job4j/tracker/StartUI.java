package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }


    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = Integer.parseInt(input.askStr("Select: "));
            actions[select].name();
            run = actions[select].execute(input, tracker);
        }
    }


    private void showMenu(UserAction[] actions) {
        this.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            this.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output), new ShowAllAction(output), new ReplaceAction(output), new DeleteAction(output), new FindIdAction(output), new FindNameAction(output), new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
