package com.example.lesson6_7.homework.part2;


import java.util.concurrent.*;

public class Tunnel extends Stage {
    private static Semaphore semaphore;
    static {
        semaphore = new Semaphore(MainClass.CARS_COUNT / 2);
    }

    public Tunnel () {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go (Car c) {
        System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(c.getName() + " начал этап: " + description);
        try {
            Thread.sleep(length / c.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(c.getName() + " закончил этап: " + description);
        semaphore.release();

    }
}
