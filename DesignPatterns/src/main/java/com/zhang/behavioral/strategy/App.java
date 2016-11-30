package com.zhang.behavioral.strategy;

/**
 * Created by Zhang on 11/30/2016 10:23 PM.
 */
public class App {

    public static void main(String[] args) {
        Animal sparky = new Dog();
        Animal tweety = new Bird();
        System.out.println("Dog: " + sparky.tryToFly());
        System.out.println("Bird: " + tweety.tryToFly());

        sparky.setFlyingType(new ItFly());
        System.out.println("Dog: " + sparky.tryToFly());
    }

}
