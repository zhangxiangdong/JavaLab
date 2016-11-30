package com.zhang.behavioral.strategy;

/**
 * Created by Zhang on 11/30/2016 10:16 PM.
 */
public class Bird extends Animal {

    public Bird() {
        setSound("Tweet");
        flyingType = new ItFly();
    }

    public void makeSoud() {
        System.out.println(getSound());
    }

}
