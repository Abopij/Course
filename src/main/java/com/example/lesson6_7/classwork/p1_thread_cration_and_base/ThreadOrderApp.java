package com.example.lesson6_7.classwork.p1_thread_cration_and_base;

public class ThreadOrderApp {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        }).start();
    }

    // нет гарантии, что первый поток будет первее
}
