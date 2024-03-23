package com.example.lesson8.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        findMaxUsesWords("Lena", "lean", "lean", "Abopij", "lean");


        Employee[] employees = {
                new Employee("Vasya", 26, 150000),
                new Employee("Abopij", 18, 85000),
                new Employee("Lesha", 18, 0),
                new Employee("Sergei", 43, 90000)
        };

        findMiddleSalaryEmployees(employees);

        findGrandEmployees(2, employees);
    }

    public static void findMaxUsesWords(String... words) {
        HashMap<String, Integer> map = new HashMap<>();
        Stream.of(words).forEach((a) -> {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
            }
        });
        map.entrySet().stream().min((a, b) -> b.getValue() - a.getValue()).ifPresent(System.out::println);
    }

    public static void findMiddleSalaryEmployees(Employee... employees) {
        long sum = Arrays.stream(employees).map(Employee::getSalary).reduce(Integer::sum).get();
        int count = employees.length;

        System.out.println(sum / count);
    }

    private static void findGrandEmployees(int n, Employee... employees) {
        System.out.println(Arrays.stream(employees).sorted((a, b) ->  b.getAge() - a.getAge()).limit(n).map(Employee::getName).collect(Collectors.joining(", ", n + " самых старших сотрудников зовут: ", ".")));
    }
}
