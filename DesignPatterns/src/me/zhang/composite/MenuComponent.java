package me.zhang.composite;

import java.util.Iterator;

/**
 * Created by Zhang on 12/5/2015 6:30 下午.
 */
public abstract class MenuComponent {

    //<editor-fold desc="组合方法">
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
    //</editor-fold>

    //<editor-fold desc="操作方法">
    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
    //</editor-fold>

    public abstract Iterator<MenuComponent> createIterator();
}
