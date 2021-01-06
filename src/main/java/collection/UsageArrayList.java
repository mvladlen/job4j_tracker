package collection;

import ru.job4j.tracker.Item;

import java.util.ArrayList;

public class UsageArrayList {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
//        ArrayList<Item> itemNames = new ArrayList<Item>();

        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
