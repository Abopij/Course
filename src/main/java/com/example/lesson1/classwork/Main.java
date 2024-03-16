package com.example.lesson1.classwork;

import com.example.lesson1.classwork.animals.Animal;
import com.example.lesson1.classwork.animals.Cat;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Buba", "white", 4); // объекты попадают в heap
        System.out.println(cat); // автоматический вызов .toString()
        cat.voice();
        System.out.println(Cat.field1);

        try {
            Cat[] cats = new Cat[2];
            cats[0].voice();
        } catch (NullPointerException e) {
            System.out.println("Null (exception)");
        }

        Animal cat1 = new Cat("Biba", "Pink", 12);
        ((Cat) cat1).catMethod();

        Object cat2 = new Cat("Biba", "Pink", 12);
        ((Cat) cat2).catMethod();

        System.out.println(cat1.equals(cat2)); // @Data включает в себя hashcode equals

    }
}