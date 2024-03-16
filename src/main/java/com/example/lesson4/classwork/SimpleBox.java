package com.example.lesson4.classwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleBox {
    private Object object;

    public void info() {
        System.out.println(object.getClass().getSimpleName() + " " + object);
    }

}
