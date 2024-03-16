package com.example.lesson2.classwork;

import lombok.Getter;

@Getter
public enum Months {
    JANUARY(1, "Январь"), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5),JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);

    int number;

    String rus;

    private Months(int number, String rus) { // нужен только внутри, так что по дефолту private. Когда мы прописываем внутри скобок число - он обращается к этому конструктору
        this.number = number;
        this.rus = rus;
    }

    Months(int number) {
        this.number = number;
    }
}
