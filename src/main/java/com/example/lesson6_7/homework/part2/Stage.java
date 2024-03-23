package com.example.lesson6_7.homework.part2;

public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription () {
        return description;
    }
    public abstract void go (Car c);
}
