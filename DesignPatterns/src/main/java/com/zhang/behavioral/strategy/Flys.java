package com.zhang.behavioral.strategy;

/**
 * Created by Zhang on 11/30/2016 10:18 PM.
 */
public interface Flys {

    String fly();

}

class ItFly implements Flys {

    @Override
    public String fly() {
        return "Flying High.";
    }
}

class CantFly implements Flys {

    @Override
    public String fly() {
        return "I can't fly.";
    }
}
