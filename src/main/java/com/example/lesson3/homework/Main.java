package com.example.lesson3.homework;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"2", "21", "6", "0"},
                {"0", "8", "0", "0"},
                {"0", "8", "0", "z"},
        };
        HandlerArray handlerArray = new HandlerArray(array);

        try {
            System.out.println(handlerArray.toStringArrays());
        } catch (RuntimeException e) {
            System.out.println("ignored");
        }

    }
}
