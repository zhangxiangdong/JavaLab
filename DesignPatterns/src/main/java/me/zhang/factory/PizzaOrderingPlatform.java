package me.zhang.factory;

import me.zhang.factory.chicago.ChicagoStylePizzaStore;
import me.zhang.factory.ny.NYStylePizzaStore;

/**
 * Created by Zhang on 11/2/2015 8:52 下午.
 */
public class PizzaOrderingPlatform {

    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYStylePizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoStylePizzaStore();

        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName());
    }

}
