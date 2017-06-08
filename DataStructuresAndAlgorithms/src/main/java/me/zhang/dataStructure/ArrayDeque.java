package me.zhang.dataStructure;

/**
 * Created by zhangxiangdong on 2017/6/8.
 */
public class ArrayDeque<E> implements Deque<E> {

    private static final int DEFAULT_CAPACITY = 1024;
    private final E[] elements;
    private int f;
    private int size;

    public ArrayDeque() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayDeque(int capacity) {
        //noinspection unchecked
        elements = (E[]) new Object[capacity];
    }

    @Override
    public void addFirst(E e) {
        if (size == elements.length) {
            throw new IllegalStateException("Queue is full");
        }
        int available = Math.abs((f - 1 ) % elements.length);
        elements[available] = e;
        size++;
        f = available;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return elements[f];
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E first = elements[f];
        elements[f] = null;
        f = (f + 1) % elements.length;
        size--;
        return first;
    }

    @Override
    public void addLast(E e) {
        if (size == elements.length) {
            throw new IllegalStateException("Queue is full");
        }
        int available = (f + size) % elements.length;
        elements[available] = e;
        size++;
    }

    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        }
        int l = (f - 1 + size) % elements.length; // Last element index
        return elements[l];
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        int l = (f - 1 + size) % elements.length;
        E last = elements[l];
        elements[l] = null;
        size--;
        return last;
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
