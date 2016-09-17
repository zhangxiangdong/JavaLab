package me.zhang.templatemethod;

/**
 * Created by Zhang on 11/18/2015 8:43 下午.
 */
public class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }

    @Override
    void addCondimentsPrompt() {
        System.out.println("Would you like lemon with your tea (y/n)?");
    }

    @Override
    protected boolean customerWantsCondiments() {
        return getUserInput().toLowerCase().startsWith("y");
    }
}
