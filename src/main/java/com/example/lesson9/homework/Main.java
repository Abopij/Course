package com.example.lesson9.homework;

import com.example.lesson9.homework.entities.Animal;
import com.example.lesson9.homework.entities.Worker;
import com.example.lesson9.homework.services.TableHandler;

public class Main {
    public static void main(String[] args) {
        TableHandler.createTablesFromPackage("com.example.lesson9.homework.entities");
//        TableHandler.createTable(Worker.class);
        System.out.println(TableHandler.addEntity(new Animal("Dog", 12, "Lena")));
        System.out.println(TableHandler.addEntity(new Worker("Ilya", 175000)));
    }
}
