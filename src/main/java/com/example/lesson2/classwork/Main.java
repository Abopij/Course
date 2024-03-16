package com.example.lesson2.classwork;


public class Main {
    public static void main(String[] args) {
    //    Flyable[] flyables = { new Duck() };
    // instanceof проверяет относится ли объект к данному типу
        System.out.println(new Duck() instanceof Flyable);

        Months month = Months.JANUARY;
        System.out.println(month.getNumber() + " " + month.getRus());
    }
}
