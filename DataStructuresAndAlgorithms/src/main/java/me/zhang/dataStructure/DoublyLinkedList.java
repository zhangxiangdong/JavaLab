package me.zhang.dataStructure;

/**
 * Created by zhangxiangdong on 2017/5/4.
 */
public class DoublyLinkedList<E> {

    private final Node<E> header;
    private final Node<E> tailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        tailer = new Node<>(header, null, null);
        header.next = tailer;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.next.element;
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tailer.prev.element;
    }

    public void addFirst(E firstElement) {
        addBetween(header, firstElement, header.next);
    }

    public void addLast(E lastElement) {
        addBetween(tailer.prev, lastElement, tailer);
    }

    private void addBetween(Node<E> prev, E element, Node<E> next) {
        Node<E> newNode = new Node<>(prev, element, next);
        prev.next = newNode;
        next.prev = newNode;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.next);
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(tailer.prev);
    }

    private E remove(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        prev.next = next;
        next.prev = prev;

        size--;

        return node.element;
    }

    static class Node<E> {
        Node<E> prev;
        E element;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

}
