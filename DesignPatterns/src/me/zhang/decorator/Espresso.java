package me.zhang.decorator;

/**
 * Created by Zhang on 10/24/2015 9:19 下午.
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
