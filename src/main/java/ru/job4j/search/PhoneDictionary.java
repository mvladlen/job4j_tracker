package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> byName = o -> o.getName().equals(key);
        Predicate<Person> bySurname = o -> o.getSurname().equals(key);
        Predicate<Person> byAddress = o -> o.getAddress().equals(key);
        Predicate<Person> byPhone = o -> o.getPhone().equals(key);
        Predicate<Person> combine = byName.or(bySurname).or(byAddress).or(byPhone);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}