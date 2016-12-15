package com.zhang.behavioral.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zhang on 12/15/2016 9:58 PM.
 */
public class NameRepository implements Container<String> {

    private List<String> names = new ArrayList<>();

    public NameRepository(String... names) {
        this.names.addAll(Arrays.asList(names));
    }

    public void addName(String name) {
        names.add(name);
    }

    @Override
    public Iterator<String> iterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator<String> {

        int index;

        @Override
        public boolean hasNext() {
            return index < names.size();
        }

        @Override
        public String next() {
            return hasNext() ? names.get(index++) : null;
        }
    }

}
