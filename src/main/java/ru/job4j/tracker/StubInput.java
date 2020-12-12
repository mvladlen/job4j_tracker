package ru.job4j.tracker;

public class StubInput implements Input {
    public String askStr(String question) {
        System.out.println(question);
        return null;
    }

    ;

    public int askInt(String question) {
        System.out.println(question);
        return 0;
    }

    ;
}
