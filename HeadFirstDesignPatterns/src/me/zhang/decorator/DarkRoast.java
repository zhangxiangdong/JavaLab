package me.zhang.decorator;

/**
 * Created by Zhang on 10/24/2015 9:23 下午.
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast";
    }

    @Override
    public double cost() {
        return .99;
    }
}
