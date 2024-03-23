package com.example.lesson6_7.classwork.p5_executor_service;

import java.util.concurrent.*;

public class ExecutorServiceApp {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Java is excellent language programming";
            }
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        service.shutdown();
    }
}
