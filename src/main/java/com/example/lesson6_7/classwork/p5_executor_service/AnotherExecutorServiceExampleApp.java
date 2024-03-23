package com.example.lesson6_7.classwork.p5_executor_service;

import java.util.concurrent.*;

public class AnotherExecutorServiceExampleApp {
    public static void main(String[] args) throws InterruptedException {
        /*
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "Java is excellent language programming";
            }
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("END");
         */

        ExecutorService service = Executors.newFixedThreadPool(4, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setPriority(10);
                t.setName("ABC");
                System.out.println("Created");
                return t;
            }
        });
        service.execute(() -> System.out.println(1));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(2));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(3));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(4));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(5));
        Thread.sleep(2000);
        service.execute(() -> System.out.println(6));
        Thread.sleep(2000);

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        service.shutdown();
    }
}
