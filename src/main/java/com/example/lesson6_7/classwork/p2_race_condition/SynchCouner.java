package com.example.lesson6_7.classwork.p2_race_condition;

public class SynchCouner {
    private int c;
    public int value() {
        return c;
    }

    public SynchCouner() {
        c = 0;
    }
    public synchronized void inc() {
        c++;
    }
    public synchronized void dec() {
        c--;
    }
}
