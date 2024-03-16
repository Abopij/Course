package com.example.lesson5.homework;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        String[] words = {
                "table",
                "chair",
                "java",
                "python",
                "spring",
                "java",
                "java",
                "table",
                "table",
                "table",
                "python",
                "python",
                "chair",
                "python",
                "python",
                "spring",
                "java",
                "java",
                "table",
                "table"
        };
        HashSet<String> uniqueWords = getSetArray(words);
        System.out.println(uniqueWords);



        HashMap<String, Integer> counter = getUses(words);
        System.out.println(counter);

        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Vasya", "8902");
        phoneDirectory.add("Vasya", "8903");
        phoneDirectory.add("Vasya", "8904");
        phoneDirectory.add("Vasya", "8905");
        phoneDirectory.add("Masha", "8908");
        phoneDirectory.add("Petor", "8900");
        phoneDirectory.add("Valentine", "8901");
        System.out.println(phoneDirectory.getPhones());

        System.out.println(phoneDirectory.get("Vasya"));
        
    }

    public static <K> HashMap<K, Integer> getUses(K[] keys) {
        HashMap<K, Integer> counter = new HashMap<>();
        for (K key : keys) {
            if (!counter.containsKey(key)) {
                counter.put(key, 1);
            } else {
                counter.computeIfPresent(key, (k, v) -> (v + 1));
            }
        }
        return counter;
    }

    public static <E> HashSet<E> getSetArray(E[] array) {
        return new HashSet<>(List.of(array));
    }
}

