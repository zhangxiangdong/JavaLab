package com.zhang.behavioral.strategy;

/**
 * Created by Zhang on 11/30/2016 10:13 PM.
 */
public class Dog extends Animal {

    public Dog() {
        setSound("Bark");
        flyingType = new CantFly();
    }

    public void digAHole() {
        System.out.println("Dug a hole.");
    }

}
