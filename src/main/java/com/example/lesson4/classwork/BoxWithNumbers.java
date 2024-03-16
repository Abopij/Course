package com.example.lesson4.classwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoxWithNumbers<N extends Number> { // WildCard-ы
    private N[] array;

    public BoxWithNumbers(N... array) {
        this.array = array;
    }

    public double average() {
        double avg = 0.0;
        for (int i = 0; i < array.length; i++) {
            avg += array[i].doubleValue();
        }
        avg /= array.length;
        return avg;
    }

    public boolean compareAverage(BoxWithNumbers<?> another) { // ? extends Number - по факту мы сюда не можем запихать строку, поэтому обозначение области и тут избыточно
        return Math.abs(average() - another.average()) < 0.00001;
    }

}
