package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Positive {
    public static void main(String[] args) {
        List<Integer> mesh = Arrays.asList(1, -5, 8, -76, 0);
        List<Integer> positive = mesh.stream().filter(x -> x > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
