package com.example.lesson9.classwork.part1.reflection.part2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class testClass = TestClass.class;
        Method[] methods = testClass.getDeclaredMethods();
        for (Method o : methods) {
            if (o.isAnnotationPresent(MyAnno.class)) {
                o.invoke(null);
            }
        }

        System.out.println("---------");

//        List<Method> executionList = new ArrayList<>();
//        for (Method o : methods) {
//            if (o.isAnnotationPresent(MyAnno.class)) {
//                executionList.add(o);
//            }
//        }
//        executionList.sort((o1, o2) -> o2.getAnnotation(MyAnno.class).priority() - o1.getAnnotation(MyAnno.class).priority());

        Arrays.stream(methods)
                .filter(a -> a.isAnnotationPresent(MyAnno.class))
                .sorted((o1, o2) -> o2.getAnnotation(MyAnno.class).priority() - o1.getAnnotation(MyAnno.class).priority())
                .forEach(m -> {
                    try {
                        m.invoke(null);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });


    }
}
