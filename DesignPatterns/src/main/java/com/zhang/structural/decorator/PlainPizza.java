package com.zhang.structural.decorator;

/**
 * Created by Zhang on 12/5/2016 10:51 PM.
 * <p>
 * Every Pizza made will start as a PlainPizza
 */
public class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Thin dough";
    }

    @Override
    public double getCost() {
        System.out.println("Cost of Dough: " + 4.00);
        return 4.00;
    }
}
