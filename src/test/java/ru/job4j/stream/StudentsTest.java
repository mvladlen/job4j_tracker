package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StudentsTest {

    @Test
    public void studentMapping() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(10, "Surname1"));
        students.add(new Student(20, "Surname2"));
        students.add(new Student(30, "Surname3"));
        Map<String, Student> expected = new HashMap<>();
        expected.put(students.get(0).getSurname(), students.get(0));
        expected.put(students.get(1).getSurname(), students.get(1));
        expected.put(students.get(2).getSurname(), students.get(2));
        Map<String, Student> result = Students.studentMap(students);
        assertThat(result, is(expected));
    }
}