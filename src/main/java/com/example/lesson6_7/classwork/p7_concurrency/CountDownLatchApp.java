package com.example.lesson6_7.classwork.p7_concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchApp {
    public static void main(String[] args) {
        final int THREADS_COUNT = 6;

        final CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT); // сколько защелок нужно сделать (=отпустили)

        System.out.println("Начинаем");
        for (int i = 0; i < THREADS_COUNT; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    Thread.sleep(200 * w + (int) (500 * Math.random()));
                    System.out.println("Поток #" + w + " готов");
                    countDownLatch.countDown(); // защелка
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Работа закончена");
    }
}
