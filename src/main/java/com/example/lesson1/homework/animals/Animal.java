package com.example.lesson1.homework.animals;

import lombok.Data;

@Data
public class Animal {
    private String name;

    private int maxDistRun = 100;
    private int maxDistSwim = 100;

    protected static int counter;

    protected void setMaxDistRun(int maxDistRun) {
        this.maxDistRun = maxDistRun;
    }

    protected void setMaxDistSwim(int maxDistSwim) {
        this.maxDistSwim = maxDistSwim;
    }

    private int getMaxDistRun() {
        return maxDistRun;
    }

    private int getMaxDistSwim() {
        return maxDistSwim;
    }

    public Animal(String name) {
        this.name = name;
        System.out.println(++counter);
    }

    public Animal() {
        System.out.println(++counter);
    }


    public void run(int count) {
        if (count <= maxDistRun) {
            System.out.println(this.getName() + " пробежал " + count);
        } else {
            System.out.println(this.getName() + " пробежал " + maxDistRun);
        }
    }

    public void swim(int count) {
        if (count <= maxDistSwim) {
            System.out.println(this.getName() + " проплыл " + count);
        } else {
            System.out.println(this.getName() + " проплыл " + maxDistSwim);
        }
    }
}
