package com.example.lesson6_7.classwork.p7_concurrency;

import java.util.concurrent.Semaphore;

public class SimpleSemaphoreApp {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(4);

        Runnable limitedCall = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                int time = 3 + (int) (Math.random() * 4.0);
                int num = count++;
                try {
                    semaphore.acquire();
                    System.out.println("Поток #" + num + " начинает выполнять очень долгое действие");
                    Thread.sleep(time + 1000);
                    System.out.println("Поток #" + num + " завершает работу!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(limitedCall).start();
        }
    }
}
