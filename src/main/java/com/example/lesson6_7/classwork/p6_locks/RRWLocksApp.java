package com.example.lesson6_7.classwork.p6_locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RRWLocksApp {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

        new Thread(() -> {
            rwl.readLock().lock();
            System.out.println("Reading-start-a");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
            System.out.println("Reading-end-a");
        }).start();


        new Thread(() -> {
            rwl.readLock().lock();
            System.out.println("Reading-start-b");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.readLock().unlock();
            }
            System.out.println("Reading-end-b");
        }).start();

        new Thread(() -> {
            rwl.writeLock().lock();
            System.out.println("Writing-start-a");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.writeLock().unlock();
            }
            System.out.println("Writing-end-a");
        }).start();


        new Thread(() -> {
            rwl.writeLock().lock();
            System.out.println("Writing-start-b");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwl.writeLock().unlock();
            }
            System.out.println("Writing-end-b");

        }).start();
    }
}
