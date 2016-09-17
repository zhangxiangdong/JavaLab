package me.zhang.composite;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Zhang on 12/5/2015 9:14 下午.
 */
public class CompositeIterator implements Iterator<MenuComponent> {

    Stack<Iterator<MenuComponent>> stack = new Stack<>();

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty())
            return false;
        else {
            Iterator<MenuComponent> iterator = stack.peek();
            if (iterator.hasNext()) {
                return true;
            } else {
                stack.pop();
                return hasNext();
            }
        }
    }

    @Override
    public MenuComponent next() {
        if (hasNext()) {
            Iterator<MenuComponent> iterator = stack.peek();
            MenuComponent component = iterator.next();
            //region 获取子菜单迭代器，压入栈
            if (component instanceof Menu)
                stack.push(component.createIterator());
            //endregion
            return component;
        }
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
