package com.example.lesson6_7.classwork.p1_thread_cration_and_base;

public class ThreadStopApp {
    public static void main(String[] args) {
        //badIdea();
        correct();
    }


    public static void correct() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean inter = false;
                while (true) {
                    if (Thread.currentThread().isInterrupted() || inter) break;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("inter = true");
                        inter = true;
                    }
                    System.out.println("tick");
                }
            }
        });
        t.start();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt(); // поток останавливается, но если он спал, вылезет ошибка (см. выше)
    }
    public static void badIdea() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("tick");
                }
            }
        });
        t.start();

        try {
            Thread.sleep(3000);
            t.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
