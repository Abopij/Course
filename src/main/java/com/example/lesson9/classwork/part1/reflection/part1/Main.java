package com.example.lesson9.classwork.part1.reflection.part1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Main.class.getName());
//        System.out.println(String.class);
//        System.out.println(int.class);
//        System.out.println(int[].class);
//        System.out.println(int[][].class);
//        System.out.println(void.class);

        Class stringClass1 = "Java".getClass();
        Class stringClass2 = String.class;
        try {
            Class stringClass3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Class classCat = Cat.class;
        Method[] methods = classCat.getMethods();
        for (Method o : methods) {
            System.out.println(o.getName());
        }
        System.out.println("--------");
        Method[] methods1 = classCat.getDeclaredMethods();
        for (Method o : methods1) {
            System.out.println(o.getName());
        }
        System.out.println("--------");

        Cat cat = new Cat(1,2,3);

        methods1[1].setAccessible(true);
        try {
            methods1[1].invoke(cat);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--------");

        int mods = methods1[0].getModifiers();
        System.out.println(Modifier.isPublic(mods)); // много-много других is

        System.out.println("--------");

        Field[] fields = classCat.getDeclaredFields();

        System.out.println(Arrays.toString(fields));
        try {
            System.out.println(fields[1].get(cat));
        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
        }

        try {
            Cat cat2 = (Cat) classCat.newInstance();
            System.out.println(cat2);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

//        try {
//            Cat cat3 = (Cat) classCat.getConstructor(int.class, int.class, int.class).newInstance(20,20,30);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("--------");
//        try {
//            ClassLoader classLoader = new URLClassLoader(new URL[] {new File("C:\\Users\\user\\IdeaProjects\\Course\\src\\main\\java\\com\\example\\lesson9\\classwork\\reflection\\part1_1\\classes\\").toURL()});
//            Class humanClass = classLoader.loadClass("Human.class");
//            Object humanObj = humanClass.getConstructor(String.class, int.class).newInstance("Abopij", 20);
//            Method greetingMethods = humanClass.getDeclaredMethod("greetings");
//            greetingMethods.invoke(humanObj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        Integer o = 9;
        System.out.println(o.getClass().getSimpleName());






    }
}
