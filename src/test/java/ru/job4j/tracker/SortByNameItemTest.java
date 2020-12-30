package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortByNameItemTest {
    @Test
    public void SortItems() {
        List<Item> items = Arrays.asList(
                new Item(4, "Fix bugs"),
                new Item(2, "Impl task"),
                new Item(1, "Reboot server")
        );
        List<Item> testItems = Arrays.asList(
                new Item(1, "Reboot server"),
                new Item(2, "Impl task"),
                new Item(4, "Fix bugs")
        );
        Collections.sort(items);
        Assert.assertEquals(items, testItems);
    }
}