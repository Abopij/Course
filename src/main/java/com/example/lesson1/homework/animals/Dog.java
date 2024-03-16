package com.example.lesson1.homework.animals;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Dog extends Animal{

    public Dog(String name) {
        super(name);
        setMaxDistRun(500);
        setMaxDistSwim(10);
    }
}
