package me.zhang.templatemethod;

/**
 * Created by Zhang on 11/18/2015 8:41 下午.
 */
public class Coffee extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    @Override
    void addCondimentsPrompt() {
        System.out.println("Would you like milk and sugar with your coffee (y/n)?");
    }

    @Override
    protected boolean customerWantsCondiments() {
        return getUserInput().toLowerCase().startsWith("y");
    }

}
