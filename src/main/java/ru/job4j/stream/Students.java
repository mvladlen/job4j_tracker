package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Students {
    public static Map<String, Student> studentMap(ArrayList<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getSurname, student -> student, (o1, o2) -> o2));


    }

    public static List<Integer> testMap(Integer[][] integers) {
        return Arrays.stream(integers)
                .flatMap(
                        Stream::of)
                .collect(Collectors.toList());

    }
}
