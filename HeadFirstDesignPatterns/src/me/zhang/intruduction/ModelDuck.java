package me.zhang.intruduction;

import me.zhang.intruduction.behavior.FlyNoWay;
import me.zhang.intruduction.behavior.Quack;

/**
 * Created by Zhang on 10/6/2015 12:44 下午.
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
