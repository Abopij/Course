package com.example.lesson9.classwork.part1.reflection.part2;

public class TestClass {

    @MyAnno(priority = 9)
    public static void method1() {
        System.out.println("method 1");
    }
    @MyAnno
    public static void method2() {
        System.out.println("method 2");
    }
    @MyAnno(priority = 10)
    public static void method3() {
        System.out.println("method 3");
    }

}
