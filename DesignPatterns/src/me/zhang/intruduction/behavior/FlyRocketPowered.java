package me.zhang.intruduction.behavior;

/**
 * Created by Zhang on 10/6/2015 12:45 下午.
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
