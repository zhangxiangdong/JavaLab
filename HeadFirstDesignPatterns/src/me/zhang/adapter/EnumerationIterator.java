package me.zhang.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by Zhang on 11/11/2015 8:44 下午.
 */
public class EnumerationIterator<E> implements Iterator {

    Enumeration<E> enumeration;

    public EnumerationIterator(Enumeration<E> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public E next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
