package com.example.lesson2.classwork;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnotherMainApp {
    class Inner {
        int innerValue;

        public Inner(int innerValue) {
            this.innerValue = innerValue;
        }

        public void innerMethod() {
            System.out.println(innerValue);
            System.out.println(outerValue);
        }
    }

    int outerValue;

    public void outerMethod(int value) {
        new Inner(value) {
            @Override
            public void innerMethod() {
                System.out.println(innerValue);
            }
        }.innerMethod();
    }

    public static void main(String[] args) {
        AnotherMainApp anotherMainApp = new AnotherMainApp() {
            @Override
            public void outerMethod(int value) {
                System.out.println("Bebe");
            }
        };
        System.out.println(anotherMainApp.getClass().getName());


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        });
        thread.start();

        new Thread(() -> System.out.println("some")).start();

        System.out.println(
        Stream.of(1,2,3,4,5,6,7,8,9,10).filter((a) -> a >= 7).collect(Collectors.toList()));
    }
}
