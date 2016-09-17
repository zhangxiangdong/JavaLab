package me.zhang.adapter;

/**
 * Created by Zhang on 11/10/2015 8:53 下午.
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
