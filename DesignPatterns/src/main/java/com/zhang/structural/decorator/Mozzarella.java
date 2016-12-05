package com.zhang.structural.decorator;

/**
 * Created by Zhang on 12/5/2016 10:58 PM.
 */
public class Mozzarella extends ToppingDecorator {
    public Mozzarella(Pizza tempPizza) {
        super(tempPizza);

        System.out.println("Adding Dough");
        System.out.println("Adding Moz");
    }

    // Returns the result of calling getDescription() for
    // PlainPizza and adds " mozzarella" to it
    @Override
    public String getDescription() {
        return tempPizza.getDescription() + ", mozzarella";
    }

    @Override
    public double getCost() {
        System.out.println("Cost of Moz: " + .50);
        return tempPizza.getCost() + .50;
    }
}
