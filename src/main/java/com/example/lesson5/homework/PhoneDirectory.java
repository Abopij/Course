package com.example.lesson5.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDirectory {
    private HashMap<String, HashSet<String>> phones = new HashMap<>();

    public void add(String name, String number) {
        if (!phones.containsKey(name)) {
            HashSet<String> set = new HashSet<>();
            set.add(number);
            phones.put(name, set);
        } else {
            HashSet<String> set = phones.get(name);
            set.add(number);
            phones.put(name, set);
        }
    }

    public HashSet<String> get(String name) {
        return phones.getOrDefault(name, null);
    }

}
