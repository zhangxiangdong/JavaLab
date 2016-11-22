package me.zhang.decorator;

/**
 * Created by Zhang on 10/24/2015 9:32 下午.
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage espresso = new Espresso(); // 浓咖啡，啥都不加
        espresso = new Tall(espresso); // 小杯
        System.out.println(espresso.getDescription() + " $" + espresso.cost());

        Beverage darkRoast = new DarkRoast(); // 深焙咖啡
        darkRoast = new Grande(darkRoast); // 中杯
        darkRoast = new Mocha(darkRoast); // 加点摩卡
        darkRoast = new Mocha(darkRoast); // 再加点摩卡
        darkRoast = new Whip(darkRoast); // 加点奶泡
        System.out.println(darkRoast.getDescription() + " $" + darkRoast.cost());

        Beverage houseBlend = new HouseBlend(); // 综合咖啡
        houseBlend = new Venti(houseBlend); // 大杯
        houseBlend = new Soy(houseBlend); // 加点豆浆
        houseBlend = new Mocha(houseBlend); // 加点摩卡
        houseBlend = new Whip(houseBlend); // 加点奶泡
        houseBlend = new Milk(houseBlend); // 加点牛奶

        System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());
    }

}
