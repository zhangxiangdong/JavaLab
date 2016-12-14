package com.zhang.behavioral.template;

/**
 * Created by Zhang on 12/14/2016 10:15 PM.
 */
public class VeggieHoagie extends Hoagie {

    String[] veggiesUsed = {"Lettuce", "Tomatoes", "Onions", "Sweet Peppers"};
    String[] condimentsUsed = {"Oil", "Vinegar"};

    @Override
    void addMeat() {

    }

    @Override
    void addCheese() {

    }

    @Override
    void addVegetables() {
        System.out.print("Adding the Vegetables: ");
        for (String vegetable : veggiesUsed) {
            System.out.print(vegetable + " ");
        }
    }

    @Override
    void addCondiments() {
        System.out.print("Adding the Condiments: ");
        for (String condiment : condimentsUsed) {
            System.out.print(condiment + " ");
        }
    }

    @Override
    boolean customerWantsMeat() {
        return false;
    }

    @Override
    boolean customerWantsCheese() {
        return false;
    }
}
