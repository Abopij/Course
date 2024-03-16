package com.example.lesson1.homework;

import com.example.lesson1.homework.animals.Animal;
import com.example.lesson1.homework.animals.Cat;
import com.example.lesson1.homework.animals.Dog;
import com.example.lesson1.homework.animals.Tiger;

public class Main {

    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Boba"),
                new Tiger("Tiga"),
                new Animal("Vire"),
                new Cat("Nona")
        };

        for (Animal animal : animals) {
            animal.run(250);
            animal.swim(250);
        }

    }
}
