package com.example.lesson6_7.classwork.p1_thread_cration_and_base;

public class AnonymousExampleClass {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        try {
            t.join(); // поток ждет когда t поток перестанет работать и только потом пойдеи дальше
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END"); // отпечатывается не сразу благодяря join();
    }
}
