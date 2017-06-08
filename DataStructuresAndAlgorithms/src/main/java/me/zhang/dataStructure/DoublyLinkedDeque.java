package me.zhang.dataStructure;

/**
 * Created by zhangxiangdong on 2017/6/8.
 */
public class DoublyLinkedDeque<E> implements Deque<E> {

    private DoublyLinkedList<E> elements = new DoublyLinkedList<>();

    @Override
    public void addFirst(E e) {
        elements.addFirst(e);
    }

    @Override
    public E first() {
        return elements.first();
    }

    @Override
    public E removeFirst() {
        return elements.removeFirst();
    }

    @Override
    public void addLast(E e) {
        elements.addLast(e);
    }

    @Override
    public E last() {
        return elements.last();
    }

    @Override
    public E removeLast() {
        return elements.removeLast();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
