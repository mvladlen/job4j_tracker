package ru.job4j.tracker;

/**
 * Главный класс для управления меню и объектами
 */
public class StartUI {
    /**
     * @Output - интерфейс для вывода данных
     */
    private final Output out;

    /**
     * Конструктор для меню
     *
     * @param out - интерфейс для вывода
     */
    public StartUI(Output out) {
        this.out = out;
    }

    /**
     * Главный метод для инициализации объектов и меню
     *
     * @param args - не используется
     */
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output), new ShowAllAction(output),
                new ReplaceAction(output), new DeleteAction(output),
                new FindIdAction(output), new FindNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
    /*
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = Integer.parseInt(input.askStr("Select: "));
            actions[select].name();
            run = actions[select].execute(input, tracker);
        }
    }*/

    /**
     * Инициализация обхектов и параметров
     *
     * @param input   - интерфейс ввода
     * @param tracker - объект тракер
     * @param actions - елементы меню
     */
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    /**
     * Метод показа меню
     *
     * @param actions - элементы меню
     */
    private void showMenu(UserAction[] actions) {
        this.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            this.out.println(index + ". " + actions[index].name());
        }
    }
}
