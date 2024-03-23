package com.example.lesson9.classwork.part1.reflection.part1.human;

public class Human {
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greetings() {
        System.out.println("hello " + name);
    }
}
