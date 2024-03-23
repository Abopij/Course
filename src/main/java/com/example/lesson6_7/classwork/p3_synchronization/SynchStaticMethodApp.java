package com.example.lesson6_7.classwork.p3_synchronization;

public class SynchStaticMethodApp {

    public static void main(String[] args) {
        SynchStaticMethodApp e1 = new SynchStaticMethodApp();
        SynchStaticMethodApp e2 = new SynchStaticMethodApp();
        new Thread(() -> classMethod()).start();
        new Thread(() -> e1.objectMethod()).start();

        // статичный метод с синх и обычный синх работают параллельно
    }

    public synchronized static void classMethod() {
        System.out.println("Synch Static Method Start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Static END");
    }

    public synchronized void objectMethod() {
        System.out.println("Such Method Start");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("END");
    }


}
