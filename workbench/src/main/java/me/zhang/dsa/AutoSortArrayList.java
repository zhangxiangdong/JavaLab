package me.zhang.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Zhang on 8/27/2017 12:57 PM.
 */
public class AutoSortArrayList<T> extends ArrayList<T> implements AutoSortList<T> {

    @Override
    public boolean add(T e) {
        boolean result = super.add(e);
        Collections.sort((List) this);
        return result;
    }

    @Override
    public T last() {
        if (size() == 0) {
            throw new NoSuchElementException("Empty list");
        }
        return get(size() - 1);
    }

    @Override
    public T pollLast() {
        if (size() == 0) {
            return null;
        }
        int last = size() - 1;
        return remove(last);
    }

}
