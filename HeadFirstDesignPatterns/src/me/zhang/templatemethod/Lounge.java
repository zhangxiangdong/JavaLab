package me.zhang.templatemethod;

/**
 * Created by Zhang on 11/18/2015 9:46 下午.
 */
public class Lounge {

    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea();
        System.out.println("Making tea...");
        tea.prepareRecipe();

        System.out.println("*******************");

        CaffeineBeverage coffee = new Coffee();
        System.out.println("Making coffee...");
        coffee.prepareRecipe();
    }

}
