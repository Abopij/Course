package com.example.lesson2.homework.obstacles;

import com.example.lesson2.homework.interfaces.Obstacle;
import com.example.lesson2.homework.interfaces.RunAndJumpAble;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Treadmill implements Obstacle {
    private int distance;

    @Override
    public boolean decide(RunAndJumpAble runAble) {
        return runAble.run(distance);
    }
}
