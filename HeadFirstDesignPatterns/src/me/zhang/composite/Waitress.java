package me.zhang.composite;

import java.util.Iterator;

/**
 * Created by Zhang on 12/5/2015 8:44 下午.
 */
public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }

    public void printVegetarianMenu() {
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        System.out.println("\nVEGETARIAN MENU\n----");

        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            try {
                // 只有菜单项实现了isVegetarian方法，菜单调用抛出默认的异常
                if (menuComponent.isVegetarian())
                    menuComponent.print();
            } catch (UnsupportedOperationException e) { // 捕获菜单抛出的异常
//                e.printStackTrace();
            }
        }
    }
}
