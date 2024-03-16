package com.example.lesson1.classwork.animals;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    protected String name;
    protected String color;
    protected int age;
    public void voice() {
        System.out.println(name + " voice");
    }
}
