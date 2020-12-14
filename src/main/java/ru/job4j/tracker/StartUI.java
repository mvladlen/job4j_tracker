package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(0, name);
        tracker.add(item);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit an Item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            System.out.println("Item replaced");                        // вывод об успешности операции
        } else {
            System.out.println("Item not replaced");                        // вывод об ошибке
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {

        System.out.println("=== Delete an Item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            System.out.println("Item deleted");                        // вывод об успешности операции
        } else {
            System.out.println("Error. Item not deleted");                        // вывод об ошибке
        }

    }

    public static void findItemById(Input input, Tracker tracker) {

        System.out.println("=== Find an Item by Id ===");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {

        System.out.println("=== Find an Item by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) System.out.println(item);
        } else System.out.println("Заявки с таким name не найдены");
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            actions[select].name();
            run = actions[select].execute(input, tracker);
        }
    }


    private static void showMenu() {
        System.out.printf("%n Menu. %n" +
                "0. Add new Item %n" +
                "1. Show all items %n" +
                "2. Edit item %n" +
                "3. Delete item %n" +
                "4. Find item by Id %n" +
                "5. Find items by name %n" +
                "6. Exit Program %n");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(), new ShowAllAction(), new ReplaceAction(), new DeleteAction(), new FindIdAction(), new FindNameAction(), new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
