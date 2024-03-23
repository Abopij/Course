package com.example.lesson6_7.classwork.p9_additional_themes;

public class ThreadException {
    public static void main(String[] args) {
        /*
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int x = 10 / 0;
                }
            }).start();
        } catch (ArithmeticException e) {
            System.out.println("catched"); // ек можем перехватить
        }
         */


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int x = 10;
                System.out.println(1);
                x = x / 0;
                System.out.println(2);
            }
        });
        // Thread.setDefaultUncaughtExceptionHandler(...);
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                e.printStackTrace();
                System.out.println("Catched");
            }
        });
        t.start();
    }
}
