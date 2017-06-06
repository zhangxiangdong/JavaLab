package me.zhang.dataStructure;

/**
 * Created by zhangxiangdong on 2017/6/6.
 */
public class CircularlyLinkedQueue<E> implements CircularQueue<E> {

    private final CircularlyLinkedList<E> elements = new CircularlyLinkedList<>();

    @Override
    public void enqueue(E e) {
        elements.addLast(e);
    }

    @Override
    public E dequeue() {
        return elements.removeFirst();
    }

    @Override
    public E first() {
        return elements.first();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public void rotate() {
        elements.rotate();
    }

}
