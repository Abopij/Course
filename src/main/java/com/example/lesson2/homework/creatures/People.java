package com.example.lesson2.homework.creatures;

import com.example.lesson2.homework.interfaces.RunAndJumpAble;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class People implements RunAndJumpAble {
    private String name;
    private final int maxJump = 2;
    private final int maxRun = 1200;

    @Override
    public boolean jump(int height) {
        if (height >= 0 && height <= maxJump) {
            System.out.println(name + " прыгнул");
            return true;
        } else {
            System.out.println(name + " не смог перепрыгнуть");
            return false;
        }
    }

    @Override
    public boolean run(int distance) {
        if (distance >= 0 && distance <= maxRun) {
            System.out.println(name + " пробежал");
            return true;
        } else {
            System.out.println(name + " не смог пробежать");
            return false;
        }
    }
}
