package com.example.lesson3.classwork;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            int x = 10 / 0;
        } catch(ArithmeticException e) {

        }

        try(FileOutputStream output = new FileOutputStream("path.txt")) {
            output.write(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Integer[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 7 || arr[i][j] == 3) {
                    throw new MyLibMatrixProcessingException(i, j, arr);
                }
            }
        }

    }
}
