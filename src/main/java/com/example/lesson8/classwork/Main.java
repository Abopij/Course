package com.example.lesson8.classwork;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //matchExample();

        mappingEx();
        reduceEx();

        streamFromFilesEx();

        simpleStringEx();

        readStreamFile();

        intStreamEx();
    }

    public static void commonEx() {
        doSomething(() -> System.out.println("10"));
        doSomething(() -> System.out.println("20"));

        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        integers = integers.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        integers.stream().forEach(integer -> System.out.println(integer));
        System.out.println(integers);

        //Stream.of();
        //IntStream, DoubleStream
        Stream.of("AAAAA", "KKK", "Q", "R").map(String::length).distinct().forEach(System.out::println);
        // User::new - вызов конструктора

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        list.stream().filter(n -> n > 6).findAny().ifPresent(System.out::println);

        Optional<Integer> opt = list.stream().findAny();
        if (opt.isPresent()) {
            System.out.println(opt.get() + ";");
        }
    }
    public static void doSomething(Runnable runnableObj) {
        new Thread(runnableObj).start();
    }

    private static void matchExample() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(list.stream().allMatch(n -> n < 10));  // boolean все числа < 10 иначе false
        System.out.println(list.stream().anyMatch(n -> n == 10)); // хотя бы один элемент подходти по условию
        // System.out.println(list.stream().noneMatch(n -> n == 10)); // не должен подходить ни один

    }

    private static void mappingEx() {
        Function<String, Integer> _strToLen = String::length;
        Function<String, Integer> strToLen = s -> s.length();
        Predicate<Integer> evenNumberFilter = n -> n % 2 == 0;
        Function<Integer, Integer> cube = n -> n * n * n;
        Stream.of(1, 2, 3).map(n -> Math.pow(n, 3));

        List<String> list = Arrays.asList("A",  "BB", "C", "DDDD", "EE", "FFFF");
        List<Integer> wordsLength = list.stream().map(_strToLen).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(wordsLength);
    }

    private static void reduceEx() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 0;
        for (Integer o : list) {
            sum += o;
        }

        int streamSum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum + " " + streamSum);
    }

    private static void intStreamEx() {
        IntStream myIntStream = IntStream.of(10, 20, 30, 40, 50);
        IntStream.rangeClosed(10, 19); // от 10 до 19
        IntStream.range(10, 19); // от 10 до 18

        IntStream.rangeClosed(0, 1000).parallel().filter(a -> {
            System.out.println(Thread.currentThread().getName());
            return a > 169;
        }).count();

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        list.stream().mapToInt(v -> v).sum();
        list.stream().skip(2); // пропустит первые 2 элемента

        list.stream().limit(2);


    }

    private static void streamFromFilesEx() {
        try {
            Files.lines(Paths.get("C:\\Users\\user\\IdeaProjects\\Course\\src\\main\\java\\com\\example\\lesson8\\classwork\\1234.txt")).map(String::length).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void simpleStringEx() {
        System.out.println("Count " + Arrays.stream("A BB CC AA A AS CC C".split("\\s")).distinct().count());
    }

    private static void readStreamFile() {
        try {
        System.out.println("------------");
        Files.lines(Paths.get("C:\\Users\\user\\IdeaProjects\\Course\\src\\main\\java\\com\\example\\lesson8\\classwork\\text.txt"))
                .map(line -> line.split("\\s"))
                .distinct()
                .forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println("------------");
        Files.lines(Paths.get("C:\\Users\\user\\IdeaProjects\\Course\\src\\main\\java\\com\\example\\lesson8\\classwork\\text.txt"))
                .map(line -> line.split("\\s"))
                .map(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
        System.out.println("------------");
        System.out.println(Files.lines(Paths.get("C:\\Users\\user\\IdeaProjects\\Course\\src\\main\\java\\com\\example\\lesson8\\classwork\\text.txt"))
                .map(line -> line.split("\\s"))
                .flatMap(Arrays::stream)// !!! flatMap - преобразование многих потоков к одному
                .distinct()
                .sorted()
                .collect(Collectors.joining(", ", "Уникальные слова: ", ".")));
        System.out.println("------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
