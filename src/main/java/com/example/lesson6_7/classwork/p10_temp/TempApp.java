package com.example.lesson6_7.classwork.p10_temp;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class TempApp {
    public static void main(String[] args) {
        Vector vector = new Vector(); // является аналогом ArrayList, только синхронизированный
        Hashtable<Integer, Integer> hashtable = new Hashtable<>(); // минус в том, что все методы синхронизированы и это бьет по производительности (из-за синх на get())

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(); // решение вопроса (нет блокировки на записьб блок только на одну запись)
        //Collections.sync
        CopyOnWriteArrayList<Integer> copy = new CopyOnWriteArrayList<>();

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(6);
        arrayBlockingQueue.add(2);
        arrayBlockingQueue.add(5);


        AtomicInteger ai = new AtomicInteger(10); // атомарное
        // вся работа через методы

    }
}
