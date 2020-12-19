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
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));

    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"Bug"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));

        UserAction action = new FindNameAction(out);
        action.execute(in, tracker);
        String expected = item.toString() + "\r\n";
        assertThat(expected, is(out.toString()));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));

        UserAction action = new FindIdAction(out);
        action.execute(in, tracker);
        StringBuffer buffer = new StringBuffer();
        buffer.append(out);
        buffer.setLength(30);
        assertThat(buffer.toString(), is(
                "Item{id=1, name='Bug', created"));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        Item[] items = tracker.findAll();

        assertThat(items[0].toString().substring(0, 30), is(
                "Item{id=1, name='Bug', created"));
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