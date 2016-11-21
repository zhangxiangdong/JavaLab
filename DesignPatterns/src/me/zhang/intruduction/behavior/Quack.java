package me.zhang.intruduction.behavior;

/**
 * Created by Zhang on 10/6/2015 12:18 下午.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
