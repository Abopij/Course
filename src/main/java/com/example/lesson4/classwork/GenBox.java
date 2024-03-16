package com.example.lesson4.classwork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenBox<T> {
    private T object;

    // T - type, E - element, K - key, V - value, N - number, но придерживаться не обязательно)

    public void doSomething() {
    //    T object = new T(); нет права, в том числе и создавать массив
    //    нельзя создавать статическое поле T  static T - java не знает что загружать, так как может быть и Integer и Car

    }
}
