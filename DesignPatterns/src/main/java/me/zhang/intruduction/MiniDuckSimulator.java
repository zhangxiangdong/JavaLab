package me.zhang.intruduction;

import me.zhang.intruduction.behavior.FlyRocketPowered;

/**
 * Created by Zhang on 10/6/2015 12:34 下午.
 */
public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();
        mallard.swim();

        System.out.println("******************");

        Duck model = new ModelDuck();
        model.display();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }

}
