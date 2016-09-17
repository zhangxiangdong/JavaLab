package me.zhang.intruduction.behavior;

/**
 * Created by Zhang on 10/6/2015 12:18 下午.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
