package me.zhang.decorator;

/**
 * Created by Zhang on 10/24/2015 9:25 下午.
 */
public class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
