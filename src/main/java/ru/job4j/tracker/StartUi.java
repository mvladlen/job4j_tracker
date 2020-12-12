package ru.job4j.tracker;

import java.util.Scanner;

public class StartUi {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0: {
                    System.out.println("=== Create a new Item ====");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item = new Item(0, name);
                    tracker.add(item);
                    break;
                }
                case 1: {
                    System.out.println("=== List of Items ===");
                    tracker.showAll();
                    break;
                }
                case 2: {
                    System.out.println("=== Edit an Item ====");
                    System.out.print("Enter id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item = new Item(id, name);
                    if (tracker.replace(id, item)) {
                        System.out.println("Item replaced");                        // вывод об успешности операции
                    } else {
                        System.out.println("Item not replaced");                        // вывод об ошибке
                    }
                    break;
                }
                case 3: {
                    System.out.println("=== Delete an Item ====");
                    System.out.print("Enter id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if (tracker.delete(id)) {
                        System.out.println("Item deleted");                        // вывод об успешности операции
                    } else {
                        System.out.println("Error. Item not deleted");                        // вывод об ошибке
                    }
                    break;
                }
                case 4: {
                    System.out.println("=== Find an Item by Id ===");
                    System.out.print("Enter id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Item item = tracker.findById(id);
                    if (item != null) {
                        System.out.println(item.toString());
                    } else {
                        System.out.println("Заявка с таким id не найдена");
                    }
                    break;
                }
                case 5: {
                    System.out.println("=== Find an Item by name ===");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item[] items = tracker.findByName(name);
                    if (items.length > 0) {
                        for (Item item : items) System.out.println(item);
                    } else System.out.println("Заявки с таким name не найдены");
                    break;
                }
                case 6:
                    run = false;
            }
        }
    }

    private void showMenu() {
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUi().init(scanner, tracker);
    }
}
