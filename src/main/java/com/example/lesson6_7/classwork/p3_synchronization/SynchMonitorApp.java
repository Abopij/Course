package com.example.lesson6_7.classwork.p3_synchronization;

public class SynchMonitorApp {
    private Object monitor = new Object(); // POJO (старый добрый джава объект)
    public static void main(String[] args) {
        SynchMonitorApp e1 = new SynchMonitorApp();
        new Thread(() -> e1.method()).start();
        new Thread(() -> e1.method()).start();
        new Thread(() -> e1.method()).start();
    }

    public synchronized void method() {
        try {
            System.out.println("NonSynch-Begin " + Thread.currentThread().getName());
            for (int i = 0; i < 3; i++) {
                System.out.println(".");
                Thread.sleep(400);
            }
            System.out.println("NonSynch-End " + Thread.currentThread().getName());
            synchronized (monitor) {
                System.out.println("Synch-Begin " + Thread.currentThread().getName());
                for (int i = 0; i < 5; i++) {
                    System.out.println(".");
                    Thread.sleep(400);
                }
                System.out.println("Synch-End " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
