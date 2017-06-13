package me.zhang.dataStructure.list;

/**
 * Created by zhangxiangdong on 2017/6/13.
 */
public class DynamicArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 16;
    private E[] elements;
    private int size;

    public DynamicArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArrayList(int capacity) {
        //noinspection unchecked
        elements = (E[]) new Object[capacity];
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        shouldExpandArraySize();
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

    private void shouldExpandArraySize() {
        if (size == elements.length) {
            resize(elements.length * 2);
            System.out.println("After Expanding, elements.length: " + elements.length);
        }
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        shouldShinkArraySize();
        checkIndex(i, size);
        E removed = elements[i];
        for (int j = i; j < size - 1; j++) {
            elements[j] = elements[j + 1];
        }
        elements[size - 1] = null;
        size--;
        return removed;
    }

    private void shouldShinkArraySize() {
        if (size < elements.length / 4) {
            resize(elements.length / 2);
            System.out.println("After Shinking, elements.length: " + elements.length);
        }
    }

    private void resize(int newLength) {
        //noinspection unchecked
        E[] newElements = (E[]) new Object[newLength];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
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
            throw new IndexOutOfBoundsException("Invalid index: " + index);
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
