package com.example.lesson6_7.homework.part1;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        oneTaskThread();
        twoTaskThread();
    }

    public static void oneTaskThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);

        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void twoTaskThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);

        long a = System.currentTimeMillis();

        float[] leftArr = new float[HALF];
        float[] rightArr = new float[HALF];

        System.arraycopy(arr, 0, leftArr, 0, HALF);
        System.arraycopy(arr, HALF, rightArr, 0, HALF);

        Thread threadLeght = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                leftArr[i] = (float) (leftArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread threadRight = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                rightArr[i] = (float) (rightArr[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) * Math.cos(0.4f + (i + HALF) / 2));
            }
        });

        threadLeght.start();
        threadRight.start();

        try {
            threadLeght.join();
            threadRight.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(leftArr, 0, arr, 0, HALF);
        System.arraycopy(rightArr, 0, arr, HALF, HALF);

        System.out.println(System.currentTimeMillis() - a);
    }
}
