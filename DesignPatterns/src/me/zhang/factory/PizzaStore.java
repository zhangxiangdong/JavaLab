package me.zhang.factory;

/**
 * Created by Zhang on 10/27/2015 9:37 下午.
 */
public abstract class PizzaStore {

    /**
     * final 防止子类复写
     */
    public final Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * 具体创建比萨的知识由子类封装实现
     *
     * @param type 比萨类型
     * @return 创建的比萨
     */
    public abstract Pizza createPizza(String type);

}
