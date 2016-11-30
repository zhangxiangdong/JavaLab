package com.zhang.behavioral.strategy;

/**
 * Created by Zhang on 11/30/2016 10:12 PM.
 */
abstract public class Animal {

    private String name;
    private String sound;
    protected Flys flyingType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setFlyingType(Flys newFlyType) {
        this.flyingType = newFlyType;
    }

    // Animal pushes off the responsibility for flying to flyingType
    public String tryToFly() {
        return flyingType.fly();
    }
}
