package com.example.lesson2.homework.obstacles;

import com.example.lesson2.homework.interfaces.Obstacle;
import com.example.lesson2.homework.interfaces.RunAndJumpAble;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Wall implements Obstacle {
    private int height;

    @Override
    public boolean decide(RunAndJumpAble jumpAble) {
        return jumpAble.jump(height);
    }

}
