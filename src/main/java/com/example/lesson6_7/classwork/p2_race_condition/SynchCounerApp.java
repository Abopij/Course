package com.example.lesson6_7.classwork.p2_race_condition;

public class SynchCounerApp {
    public static void main(String[] args) {
        SynchCouner counter = new SynchCouner();

        Thread incThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.inc();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.dec();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            incThread.start();
            decThread.start();
            incThread.join();
            decThread.join(); // join-ы работают последовательно
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Значение синх. счетчика: " + counter.value());
    }
}
