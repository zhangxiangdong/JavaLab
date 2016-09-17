package me.zhang.iterator;

import java.util.Iterator;

/**
 * Created by Zhang on 11/30/2015 8:52 下午.
 */
public class AlternatingDinerMenu implements Iterable<MenuItem> {

    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public AlternatingDinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem(
                "Oreos",
                "Cookies",
                true,
                9.99
        );
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return new AlternatingDinerMenuIterator(menuItems);
    }
}
