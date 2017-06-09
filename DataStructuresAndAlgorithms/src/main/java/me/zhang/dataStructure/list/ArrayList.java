package me.zhang.dataStructure.list;

/**
 * Created by zhangxiangdong on 2017/6/9.
 */
public class ArrayList<E> implements List<E> {

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

}
