package me.zhang.composite;

import java.util.Iterator;

/**
 * Created by Zhang on 12/5/2015 9:21 下午.
 */
public class NullIterator implements Iterator<MenuComponent> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComponent next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
