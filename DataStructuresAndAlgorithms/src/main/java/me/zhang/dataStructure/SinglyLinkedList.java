package me.zhang.dataStructure;

/**
 * Created by zhangxiangdong on 2017/5/2.
 */
public class SinglyLinkedList<E> implements Cloneable {

    private Node<E> head;
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
        return head.element;
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.element;
    }

    public void addFirst(E firstElement) {
        head = new Node<>(firstElement, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E lastElement) {
        Node<E> newest = new Node<>(lastElement, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.next = newest;
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E element = head.element;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return element;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) obj;
        if (this.size != other.size) {
            return false;
        }
        Node<E> thisNode = head;
        Node<E> otherNode = other.head;
        while (thisNode != null) {
            if (!thisNode.element.equals(otherNode.element)) { // Element mismatch.
                return false;
            }
            thisNode = thisNode.next;
            otherNode = otherNode.next;
        }
        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        @SuppressWarnings("unchecked")
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
        if (size > 0) {
            other.head = new Node<>(head.element, null);
            Node<E> walk = head.next;
            Node<E> otherTail = other.head;
            while (walk != null) {
                Node<E> newNode = new Node<>(walk.element, null);
                otherTail.next = newNode;
                otherTail = newNode;
                walk = walk.next;
            }
        }
        return other;
    }

    public static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

}
