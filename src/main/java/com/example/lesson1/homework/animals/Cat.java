package com.example.lesson1.homework.animals;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Cat extends Animal {


    public Cat(String name) {
        super(name);
        setMaxDistRun(200);
    }

    @Override
    public void swim(int count) {
        System.out.println(this.getName() + " не умеет плавать");
    }

}
