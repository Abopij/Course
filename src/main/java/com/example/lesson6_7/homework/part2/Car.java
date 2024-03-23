package com.example.lesson6_7.homework.part2;

import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int CARS_COUNT;

    public static AtomicInteger count;
    static {
        count = new AtomicInteger(MainClass.CARS_COUNT);
    }

    private Race race;
    private int speed;
    private String name;

    private static int max;

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public Car(Race race, int speed, String name, int maxThread) {
        this.race = race;
        this.speed = speed;
        this.name = name;
        max = maxThread;
    }

    @Override
    public void run() {
        try {

            System.out.println(this.name + " готовится" );
            Thread.sleep( 500 + (int) (Math.random() * 800 ));
            System.out.println( this.name + " готов" );
            MainClass.BARRIER.await();


        } catch (Exception e) {
            e.printStackTrace();
        }
        for ( int i = 0 ; i < race.getStages().size(); i++) {
            race.getStages().get(i).go( this);
        }

        if (count.get() == CARS_COUNT) {
            System.out.println("WIN " + name);
        }
        count.set(0);
        MainClass.COUNT.countDown();

    }
}