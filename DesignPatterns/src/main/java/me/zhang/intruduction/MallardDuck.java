package me.zhang.intruduction;

import me.zhang.intruduction.behavior.FlyWithWings;
import me.zhang.intruduction.behavior.Quack;

/**
 * Created by Zhang on 10/3/2015 10:42 下午.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
