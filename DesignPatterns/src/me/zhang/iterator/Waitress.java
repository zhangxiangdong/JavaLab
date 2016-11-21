package me.zhang.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Zhang on 11/20/2015 8:51 下午.
 */
public class Waitress {

    List<Iterable<MenuItem>> menus;

    public Waitress(List<Iterable<MenuItem>> menus) {
        this.menus = menus;
    }

    public void printMenu() {
        for (Iterable<MenuItem> iterable : menus) {
            printMenu(iterable.iterator());
        }
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

}
