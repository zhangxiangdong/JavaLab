package me.zhang.dataStructure;

/**
 * Created by zhangxiangdong on 2017/6/6.
 */
public class ArrayQueue<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 1024;
    private final E[] elements;
    private int f = 0; // Index of first element.
    private int size = 0; // Number of elements.

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        //noinspection unchecked
        elements = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E e) {
        if (size == elements.length) {
            throw new IllegalStateException("Queue is full");
        }
        int available = (f + size) % elements.length;
        elements[available] = e;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E first = elements[f];
        elements[f] = null; // Help GC.
        f = (f + 1) % elements.length;
        size--;
        return first;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return elements[f];
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
