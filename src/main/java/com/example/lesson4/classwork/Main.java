package com.example.lesson4.classwork;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SimpleBox intBox1 = new SimpleBox(10);
        SimpleBox intBox2 = new SimpleBox(20);

        int sum = (Integer) intBox1.getObject() + (Integer) intBox2.getObject();

        System.out.println(sum);

        GenBox<Integer> genBox1 = new GenBox<>(10);
        GenBox<Integer> genBox2 = new GenBox<>(10);

        System.out.println(genBox2.getObject() + genBox1.getObject());

        BoxWithNumbers<Integer> box = new BoxWithNumbers<>(12, 7, 8, 9, 4);
        System.out.println(box.average());

        System.out.println(box.compareAverage(new BoxWithNumbers<>(12.0f, 7.0f, 8.0f, 9.0f, 4.0f)));


        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("Z", "AAAA", "BB", "C"));


        // ссылочный тип данных так как коллекции используют дженерики
        while (arrayList.remove("A")); // обязательно должен быть метод equals, иначе он не будет видеть одинаковые объекты, так как они могут быть свои

        Collections.sort(arrayList);
        System.out.println(arrayList);

        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        arrayList.sort((o1, o2) -> o1.length() - o2.length()); // написание в виде lambda

        System.out.println(arrayList);

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        LinkedList<String> linkedList = new LinkedList<>();

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        LinkedList<Integer> linkedList1 = new LinkedList<>();

        for (int i = 0; i < 1_000_000_0; i++) {
            int rdn = (int) (Math.random() * 5000);
            linkedList1.add(rdn);
            arrayList1.add(rdn);
        }

        long currentTime = new Date().getTime();
        Collections.sort(arrayList1);

        System.out.println(new Date().getTime() - currentTime);

        currentTime = new Date().getTime();
        Collections.sort(linkedList1);

        System.out.println(new Date().getTime() - currentTime);
    }

    public static <T extends Number> T getFirstElement(List<T> list) {
        return list.get(0);
    }
}
