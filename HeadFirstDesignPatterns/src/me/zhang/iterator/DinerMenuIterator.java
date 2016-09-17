package me.zhang.iterator;

import java.util.Iterator;

/**
 * Created by Zhang on 11/20/2015 9:51 下午.
 */
public class DinerMenuIterator implements Iterator<MenuItem> {

    MenuItem[] menuItems;
    int position = 0; // current loop index

    public DinerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.length || menuItems[position] == null)
            return false;
        return true;
    }

    @Override
    public MenuItem next() {
        return menuItems[position++];
    }

    @Override
    public void remove() {
        if (position <= 0)
            throw new IllegalStateException("You can't remove an item until you've done at least one next()");
        if (menuItems[position - 1] != null) {
            System.arraycopy(menuItems, position, menuItems, position - 1, menuItems.length - position);
            menuItems[menuItems.length - 1] = null;
        }
    }
}
