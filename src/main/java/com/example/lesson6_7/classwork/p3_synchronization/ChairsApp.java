package com.example.lesson6_7.classwork.p3_synchronization;

public class ChairsApp {
    public static void main(String[] args) {
        Object chair1 = new Object();
        Object chair2 = new Object();

        Thread person1 = new Thread(() -> {
            System.out.println("Чел1 подошел в стулу1");
            synchronized (chair1) {
                System.out.println("Чел1 сел на стул1");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Чел1 встал со стула1");
            }
        });
        person1.start();

        Thread person2 = new Thread(() -> {
            System.out.println("Чел2 подошел в стулу1");
            synchronized (chair1) {
                System.out.println("Чел2 сел на стул1");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Чел2 встал со стула1");
            }
        });
        person2.start();

        Thread person3 = new Thread(() -> {
            System.out.println("Чел3 подошел в стулу1");
            synchronized (chair1) {
                System.out.println("Чел3 сел на стул1");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Чел3 встал со стула1");
            }
        });
        person3.start();

        Thread person4 = new Thread(() -> {
            System.out.println("Чел4 подошел в стулу2");
            synchronized (chair2) {
                System.out.println("Чел4 сел на стул2");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Чел4 встал со стула2");
            }
        });
        person4.start();
    }
}
