package com.example.lesson1.classwork.animals;

import lombok.NoArgsConstructor;

@NoArgsConstructor
/*
    Хотя в Java по умолчанию компилятор создает конструктор без аргументов (пустой конструктор) для классов,
    но когда вы явно определяете конструктор в классе, который принимает аргументы,
    компилятор больше не создает конструктор по умолчанию автоматически.
 */
public class Cat extends com.example.lesson1.classwork.animals.Animal {

    public static int field1;
    public static int field2;

    // вызывается при загрузке класса в память
    static {
        field1 = 1;
        field2 = 2;
    }


    public Cat(String name, String color, int age) {
        super(name, color, age);
    }

    public static void doSomething() {
        System.out.println(); // нельзя использовать в статике не статик (наоборот можно)
        // так как для использования статики экземляр не нужен, и не понятно к чьему объекту обращаться и брать это поле на уровне JVM
    }
    public void catMethod() {
        System.out.println("catMethod");
    }
}
