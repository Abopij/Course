package com.example.lesson9.homework.services;

import com.example.lesson9.homework.annotation.Column;
import com.example.lesson9.homework.annotation.Table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TableHandler {

    public static ArrayList<String> createTablesFromPackage(String packageName) {
        Set<Class> classes = ClassesHandler.findAllClassesUsingClassLoader(packageName);
        classes = classes.stream().filter(a -> a.isAnnotationPresent(Table.class)).collect(Collectors.toSet());

        if (classes.isEmpty()) {
            throw new RuntimeException("In package not found entities");
        }

        ArrayList<String> result = new ArrayList<>();
        for (Class o : classes) {
            result.add(createTable(o));
        }
        return result;
    }

    public static String createTable(Class entityClass) {
        Table tableAnnotation = (Table) entityClass.getAnnotation(Table.class);

        if (tableAnnotation == null) {
            throw new RuntimeException("This object is not entity");
        }

        String title = tableAnnotation.title();
        Field[] fields = entityClass.getDeclaredFields();
        List<Field> fieldArrayList = Arrays.stream(fields).filter(b -> b.isAnnotationPresent(Column.class)).toList();

        if (fieldArrayList.isEmpty() || fieldArrayList.size() == 1) {
            throw new RuntimeException("This object is not valid");
        }

        boolean flag = false;
        String query = "CREATE TABLE IF NOT EXISTS " + title + " (";
        for (Field o : fieldArrayList) {
            query += o.getAnnotation(Column.class).name();
            String type = o.getType().getSimpleName();
            if (type.equals("Integer") || type.equals("int") || type.equals("Short") || type.equals("short") || type.equals("Long") || type.equals("long") || type.equals("Byte") || type.equals("byte")) {
                if (!flag) {
                    query += " INTEGER PRIMARY KEY AUTOINCREMENT";
                    flag = true;
                } else {
                    query += " INTEGER";
                }

            } else if (type.equals("String")) {
                query += " TEXT";
            } else {
                query += " REAL";
            }
            query += ", ";
        }
        query = query.substring(0, query.length() - 2);
        query += ");";

        if (SQLHandler.execute(query)) {
            System.out.println("The table successful create");
        } else {
            System.out.println("Error!");
            throw new RuntimeException("The table couldn't create!!!");
        }

        return query;
    }

    public static <T> String addEntity(T object) {
        Class entityClass = object.getClass();
        Table tableAnnotation = (Table) entityClass.getAnnotation(Table.class);

        if (tableAnnotation == null) {
            throw new RuntimeException("This object is not entity");
        }

        String title = tableAnnotation.title();
        Field[] fields = entityClass.getDeclaredFields();
        List<Field> fieldArrayList = Arrays.stream(fields).filter(b -> b.isAnnotationPresent(Column.class)).toList();

        if (fieldArrayList.isEmpty() || fieldArrayList.size() == 1) {
            throw new RuntimeException("This object is not valid");
        }

        boolean flag = false;
        String query = "INSERT INTO " + title + " (";
        for (int i = 1; i < fieldArrayList.size(); i++) {
            query += fieldArrayList.get(i).getAnnotation(Column.class).name() + ", ";
        }
        query = query.substring(0, query.length() - 2);
        query += ") VALUES(";

        for (int i = 1; i < fieldArrayList.size(); i++) {
            fieldArrayList.get(i).setAccessible(true);
            try {
                Object value = fieldArrayList.get(i).get(object);
                if (fieldArrayList.get(i).getType().getSimpleName().equals("String")) {
                    query += "'" + value + "'";
                } else {
                    query += value;
                }
                query += ", ";
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        query = query.substring(0, query.length() - 2);
        query += ");";

        if (SQLHandler.execute(query)) {
            System.out.println("The object successful add");
        } else {
            System.out.println("Error!");
            throw new RuntimeException("The object couldn't add!!!");
        }

        return query;
    }
}
