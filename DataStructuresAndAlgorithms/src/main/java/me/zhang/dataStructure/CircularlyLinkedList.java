package me.zhang.dataStructure;

/**
 * Created by zhangxiangdong on 2017/5/3.
 */
public class CircularlyLinkedList<E> {

    private Node<E> tail;
    private int size;

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
        return tail.next.element;
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.element;
    }

    public void addFirst(E firstElement) {
        if (isEmpty()) {
            tail = new Node<>(firstElement, null);
            tail.next = tail;
        } else {
            tail.next = new Node<>(firstElement, tail.next);
        }
        size++;
    }

    public void addLast(E lastElement) {
        addFirst(lastElement);
        tail = tail.next;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> head = tail.next;
        if (head == tail) { // Only one node exist.
            tail = null;
        } else {
            tail.next = head.next;
        }
        size--;
        return head.element;
    }

    public void rotate() {
        if (isEmpty()) {
            return;
        }
        tail = tail.next;
    }

    static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

}
