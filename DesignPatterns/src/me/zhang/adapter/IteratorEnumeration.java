package me.zhang.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by Zhang on 11/11/2015 9:01 下午.
 */
public class IteratorEnumeration<E> implements Enumeration {

    Iterator<E> iterator;

    public IteratorEnumeration(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public E nextElement() {
        return iterator.next();
    }
}
