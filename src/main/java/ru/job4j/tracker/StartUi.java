package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUi {
    public static void main(String[] args) {
        Item unit = new Item();
        LocalDateTime created = unit.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String formattedCreateDate = created.format(formatter);
        System.out.println(formattedCreateDate);
    }
}
