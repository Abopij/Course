package com.example.lesson4.homework;

import com.example.lesson4.homework.fruits.Apple;
import com.example.lesson4.homework.fruits.Fruit;
import com.example.lesson4.homework.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(array));
        swap(array, 1, 2);
        System.out.println(Arrays.toString(array));

        ArrayList<Integer> arrayList1 = toArrayList(new Integer[]{1,2,3,4,5,6,7,8,9});
        System.out.println(arrayList1);


        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < 15; i++) appleBox.add(new Apple(1.0f));

        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 10; i++) orangeBox.add(new Orange(1.5f));

        swapBox(appleBox, orangeBox);

        System.out.println(appleBox.getFruits());
        System.out.println(orangeBox.getFruits());


    }

    public static <T> void swap(T[] array, int index1, int index2) { // использование дженериков бессмысленно, лучше использовать Object[]
        T sub = array[index1];
        array[index1] = array[index2];
        array[index2] = sub;
    }

    public static <T> ArrayList<T> toArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static void swapBox(Box box1, Box box2) {
        Box<Fruit> subBox = new Box<>();
        subBox.setFruits(box1.getFruits());
        box1.setFruits(box2.getFruits());
        box2.setFruits(subBox.getFruits());
    }

}
