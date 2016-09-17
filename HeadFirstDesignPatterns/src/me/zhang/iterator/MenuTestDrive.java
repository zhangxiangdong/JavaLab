package me.zhang.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhang on 11/20/2015 10:19 下午.
 */
public class MenuTestDrive {

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        CafeMenu cafeMenu = new CafeMenu();
        AlternatingDinerMenu alternatingDinerMenu = new AlternatingDinerMenu();

        List<Iterable<MenuItem>> menus = new ArrayList<>();
        menus.add(pancakeHouseMenu);
        menus.add(dinerMenu);
        menus.add(cafeMenu);
        menus.add(alternatingDinerMenu);

        Waitress waitress = new Waitress(menus);
        waitress.printMenu();
    }

}
