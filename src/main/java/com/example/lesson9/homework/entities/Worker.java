package com.example.lesson9.homework.entities;

import com.example.lesson9.homework.annotation.Column;
import com.example.lesson9.homework.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(title = "workers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker {
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private long salary;

    public Worker(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
}
