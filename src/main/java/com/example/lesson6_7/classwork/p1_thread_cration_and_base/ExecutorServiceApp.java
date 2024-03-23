package com.example.lesson6_7.classwork.p1_thread_cration_and_base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceApp {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            final int w = i + 1;
            service.execute(() -> {
                System.out.println(w + " begin");
                try {
                    Thread.sleep(1000 + (int) (2000 * Math.random()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(w + " end");
            });
        }
        service.shutdown();
    }
}
