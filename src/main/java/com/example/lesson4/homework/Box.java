package com.example.lesson4.homework;

import com.example.lesson4.homework.fruits.Fruit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Box<T extends Fruit> implements Comparable<Box> {
    private ArrayList<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double sum = 0.0;
        for (T object : fruits)  sum += object.getWeight();
        return sum;
    }

    @Override
    public int compareTo(Box box) {
        return (int) Math.abs(this.getWeight() - box.getWeight());
    }

    public boolean compare(Box box) {
        int res = compareTo(box);
        return res < 0.00001;
    }

    public void transfer(Box<? super T> dst) {
        dst.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}
