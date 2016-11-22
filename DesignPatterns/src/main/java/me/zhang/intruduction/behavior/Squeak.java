package me.zhang.intruduction.behavior;

/**
 * Created by Zhang on 10/6/2015 12:19 下午.
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
