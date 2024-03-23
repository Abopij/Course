package com.example.lesson6_7.classwork.p1_thread_cration_and_base;

public class DaemonExample {
    public static void main(String[] args) {
        Thread tTimer = new Thread(() -> {
            int time = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                    time++;
                    System.out.println("time " + time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        tTimer.setDaemon(true); // работает, когда 1+ поток тоже работают
        tTimer.start();
        System.out.println("main -> sleep");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main -> end");

        tTimer.interrupt();
    }
}
