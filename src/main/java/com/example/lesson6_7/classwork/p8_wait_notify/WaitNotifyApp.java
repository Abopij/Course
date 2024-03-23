package com.example.lesson6_7.classwork.p8_wait_notify;

public class WaitNotifyApp {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        WaitNotifyApp waitNotifyApp = new WaitNotifyApp();
        new Thread(() -> {
            waitNotifyApp.printA();
        }).start();
        new Thread(() -> {
            waitNotifyApp.printB();
        }).start();
    }

    public void printA() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'A') { // будет засыпать, пока условие не выполнится
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println('A');
                currentLetter = 'B';
                mon.notifyAll();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (currentLetter != 'B') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println('B');
                currentLetter = 'A';
                mon.notifyAll();
            }
        }
    }
}
