package me.zhang.decorator;

/**
 * Created by Zhang on 10/24/2015 11:03 下午.
 */
public class Grande extends SizeDecorator {

    Beverage beverage;

    public Grande(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }
}
