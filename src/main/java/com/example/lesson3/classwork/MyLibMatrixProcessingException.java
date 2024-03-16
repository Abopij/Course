package com.example.lesson3.classwork;

public class MyLibMatrixProcessingException extends MyLibException{
    private int column;
    private int row;
    private Object value;

    public MyLibMatrixProcessingException(int column, int row, Object[][] array) {
        super("[" + column + "][" + row + "]   " + array[column][row]);
        this.column = column;
        this.row = row;
        this.value = array[column][row];
    }

    public MyLibMatrixProcessingException(String message) {
        super(message);
    }
}
