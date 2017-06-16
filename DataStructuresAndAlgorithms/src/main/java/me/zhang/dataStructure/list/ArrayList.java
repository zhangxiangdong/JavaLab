package me.zhang.dataStructure.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by zhangxiangdong on 2017/6/9.
 */
public class ArrayList<E> implements List<E>, Iterable<E> {

    private static final int DEFAULT_CAPACITY = 16;
    private final E[] elements;
    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        //noinspection unchecked
        elements = (E[]) new Object[capacity];
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if (elements.length == size) {
            throw new IllegalStateException();
        }
        for (int j = size; j > i; j--) {
            elements[j] = elements[j - 1];
        }
        elements[i] = e;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E removed = elements[i];
        for (int j = i; j < size - 1; j++) {
            elements[j] = elements[j + 1];
        }
        elements[size - 1] = null;
        size--;
        return removed;
    }

    @Override
    public void set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        elements[i] = e;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return elements[i];
    }

    private void checkIndex(int index, int size) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder to = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            to.append(elements[i]);
            if (i < size - 1) {
                to.append(", ");
            }
        }
        to.append("]");
        return to.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<E> {

        private int j;
        private boolean removable;

        @Override
        public boolean hasNext() {
            return j < size;
        }

        @Override
        public E next() {
            if (j == size) {
                throw new NoSuchElementException("No next element");
            }
            removable = true;
            return elements[j++];
        }

        @Override
        public void remove() {
            if (!removable) {
                throw new IllegalStateException("Nothing to remove");
            }

            ArrayList.this.remove(j - 1);
            j--;
            removable = false;
        }
    }

}
