package com.example.lesson2.homework;

import com.example.lesson2.homework.creatures.Cat;
import com.example.lesson2.homework.creatures.People;
import com.example.lesson2.homework.creatures.Robot;
import com.example.lesson2.homework.interfaces.Obstacle;
import com.example.lesson2.homework.interfaces.RunAndJumpAble;
import com.example.lesson2.homework.obstacles.Treadmill;
import com.example.lesson2.homework.obstacles.Wall;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<RunAndJumpAble> creatures = new ArrayList<>();
        ArrayList<Obstacle> obstacles =new ArrayList<>();

        creatures.add(new People("Lena"));
        creatures.add(new People("Sasha"));
        creatures.add(new Cat("Nona"));
        creatures.add(new Cat("Biba"));
        creatures.add(new Robot("YTER1209"));
        creatures.add(new Robot("BOP098"));

        obstacles.add(new Treadmill(120));
        obstacles.add(new Treadmill(200));
        obstacles.add(new Treadmill(1500));
        obstacles.add(new Wall(1));
        obstacles.add(new Wall(2));
        obstacles.add(new Wall(20));

        for (int i = 0; i < creatures.size(); i++) {
            for (int j = 0; j < obstacles.size(); j++) {
                boolean result = obstacles.get(j).decide(creatures.get(i));
                if (!result) {
                    break;
                }
            }
        }
    }
}