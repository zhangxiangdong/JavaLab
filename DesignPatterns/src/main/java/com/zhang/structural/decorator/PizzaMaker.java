package com.zhang.structural.decorator;

/**
 * Created by Zhang on 12/5/2016 11:00 PM.
 */
public class PizzaMaker {

    public static void main(String[] args) {
        Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));
        System.out.println("Ingradients: " + basicPizza.getDescription());
        System.out.println("Total Cost: " + basicPizza.getCost());
    }

}
