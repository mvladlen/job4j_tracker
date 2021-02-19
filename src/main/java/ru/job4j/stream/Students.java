package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Students {
    public static Map<String, Student> studentMap(ArrayList<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getSurname, student -> student, (o1, o2) -> o2));
    }
}
