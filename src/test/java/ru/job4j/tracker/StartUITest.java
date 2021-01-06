package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    /*
        @Test
        public void whenICreateItem() {
            Input in = new StubInput(
                    new String[]{"0", "Item name", "1"}
            );
            Tracker tracker = new Tracker();
            UserAction[] actions = {
                    new CreateAction(),
                    new ExitAction()
            };
            new StartUI().init(in, tracker, actions);
            assertThat(tracker.findAll()[0].getName(), is("Item name"));
        }

        @Test
        public void whenIReplaceItem() {
            Tracker tracker = new Tracker();
            Item item = tracker.add(new Item("Replaced item"));
            String replacedName = "New item name";
            Input in = new StubInput(
                    new String[]{"0", "1", replacedName , "1"}
            );
            UserAction[] actions = {
                    new ReplaceAction(),
                    new ExitAction()
            };
            new StartUI().init(in, tracker, actions);
            assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
        }

        @Test
        public void whenIDeleteItem() {
            Tracker tracker = new Tracker();
            Item item = tracker.add(new Item("Deleted item"));
            Input in = new StubInput(
                    new String[]{"0", "1", "1"}
            );
            UserAction[] actions = {
                    new DeleteAction(),
                    new ExitAction()
            };
            new StartUI().init(in, tracker, actions);
            assertNull(tracker.findById(item.getId()));
        }
     */
    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));

    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", item.getName(), "1"}
        );
        UserAction[] actions = {
                new FindNameAction(out), new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. === Find an Item by name ===" + ln
                        + "1. Exit" + ln
                        + item + ln
                        + "Menu." + ln
                        + "0. === Find an Item by name ===" + ln
                        + "1. Exit" + ln + ""));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindIdAction(out), new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. === Find an Item by Id ===" + ln
                        + "1. Exit" + ln
                        + item + ln
                        + "Menu." + ln
                        + "0. === Find an Item by Id ===" + ln
                        + "1. Exit" + ln + ""));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Bug"));
        Item item2 = tracker.add(new Item("Error"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(out), new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. === List of Items ===" + ln
                        + "1. Exit" + ln
                        + item1 + ln
                        + item2 + ln
                        + "Menu." + ln
                        + "0. === List of Items ===" + ln
                        + "1. Exit" + ln + ""));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "0" /* Пункты меню: неверный, верный.*/}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}