package com.example.lesson3.homework;

import com.example.lesson3.homework.exceptions.MyArrayDataException;
import com.example.lesson3.homework.exceptions.MyArraySizeException;

public class HandlerArray {
    private String[][] array;


    public HandlerArray(String[][] array) {
        this.array = array;
    }

    public int toStringArrays() {
        int sum = 0;
        if (array.length != 4) {
            throw new MyArraySizeException("The size will be 4x4 (" + array.length + "; *)");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("The size will be 4x4 (" + i + "; " + array[i].length + ")");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(array[i][j] + " not a number");
                }
            }
        }

        return sum;

    }
}
