package com.zhang.structural.decorator;

/**
 * Created by Zhang on 12/5/2016 10:59 PM.
 */
public class TomatoSauce extends ToppingDecorator {
    public TomatoSauce(Pizza tempPizza) {
        super(tempPizza);
        System.out.println("Adding Sauce");
    }

    // Returns the result of calling getDescription() for
    // PlainPizza, Mozzarella and then TomatoSauce
    @Override
    public String getDescription() {
        return tempPizza.getDescription() + ", tomato sauce";
    }

    @Override
    public double getCost() {
        System.out.println("Cost of Sauce: " + .35);
        return tempPizza.getCost() + .35;
    }
}
