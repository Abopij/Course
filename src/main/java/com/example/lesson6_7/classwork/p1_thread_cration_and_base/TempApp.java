package com.example.lesson6_7.classwork.p1_thread_cration_and_base;

public class TempApp {
    private static Integer mon = 0; // Integer immutable поэтому 0 1 2 будут разные мониторы (ссылки)
    public static void main(String[] args) {
        /*
        int w = 5;
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(w); // не можем передать i, так как он не конастанта
            }).start();
        }
        */

        new Thread(() -> {
            synchronized (mon) {
                System.out.println("1-start");
                mon++;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("1-end");
            }
        }).start();

        new Thread(() -> {
            synchronized (mon) {
                System.out.println("2-start");
                mon++;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("2-end");
            }
        }).start();

        new Thread(() -> {
            synchronized (mon) {
                System.out.println("3-start");
                mon++;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("3-end");
            }
        }).start();
    }
}
