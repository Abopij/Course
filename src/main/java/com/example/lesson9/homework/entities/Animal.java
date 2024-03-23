package com.example.lesson9.homework.entities;

import com.example.lesson9.homework.annotation.Column;
import com.example.lesson9.homework.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(title = "animals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "age")
    private int age;

    @Column(name = "name")
    private String name;

    public Animal(String type, int age, String name) {
        this.type = type;
        this.age = age;
        this.name = name;
    }
}
