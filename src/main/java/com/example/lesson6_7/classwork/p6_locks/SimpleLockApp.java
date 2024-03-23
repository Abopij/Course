package com.example.lesson6_7.classwork.p6_locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleLockApp {
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T-Before-Lock-Start-1");
                lock.lock(); // будет ждать, если другой поток сделал lock и не сделал unlock
                System.out.println("T-Get-Lock-1");
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T-Before-Lock-Start-2");
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println("Exception and unlock()");
                }
                System.out.println("T-Get-Lock-2");
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("L-Before-Lock-Start");
                try {
                    if (lock.tryLock(5, TimeUnit.SECONDS)) {
                        System.out.println("L-Get-Lock-First");
                        try {
                            Thread.sleep(8000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            lock.unlock();
                        }
                    } else {
                        System.out.println("Не очень-то и нужно было...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
