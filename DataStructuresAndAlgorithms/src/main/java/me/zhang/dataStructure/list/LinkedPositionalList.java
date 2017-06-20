package me.zhang.dataStructure.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by zhangxiangdong on 2017/6/14.
 */
public class LinkedPositionalList<E> implements PositionalList<E> {

    private final Node<E> header;
    private final Node<E> tailer;
    private int size;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        tailer = new Node<>(header, null, null);
        header.next = tailer;
    }

    private Node<E> validate(Position<E> p) {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException();
        }
        Node<E> node = (Node<E>) p;
        if (node.next == null) {
            throw new IllegalArgumentException();
        }
        return node;
    }

    private Position<E> position(Node<E> node) {
        if (node == header || node == tailer) {
            return null;
        }
        return node;
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
    public Position<E> first() {
        return position(header.next);
    }

    @Override
    public Position<E> last() {
        return position(tailer.prev);
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.prev);
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.next);
    }

    private Position<E> addBetween(Node<E> prev, E element, Node<E> next) {
        Node<E> newNode = new Node<>(prev, element, next);
        prev.next = newNode;
        next.prev = newNode;
        size++;
        return newNode;
    }

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(header, e, header.next);
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(tailer.prev, e, tailer);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(node.prev, e, node);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(node, e, node.next);
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E old = node.getElement();
        node.element = e;
        return old;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
        E element = node.getElement();
        node.element = null;
        node.prev = null;
        node.next = null;
        return element;
    }

    /**
     * A (nonstatic) inner class. Note well that each instance
     * contains an implicit reference to the containing list,
     * allowing us to call the list's methods directly.
     */
    private class PositionIterator implements Iterator<Position<E>> {

        /**
         * A Position of the containing list, initialized to the first position.
         */
        private Position<E> cursor = first();   // position of the next element to report
        /**
         * A Position of the most recent element reported (if any).
         */
        private Position<E> recent = null;       // position of last reported element

        /**
         * Tests whether the iterator has a next object.
         *
         * @return true if there are further objects, false otherwise
         */
        public boolean hasNext() {
            return (cursor != null);
        }

        /**
         * Returns the next position in the iterator.
         *
         * @return next position
         * @throws NoSuchElementException if there are no further elements
         */
        public Position<E> next() throws NoSuchElementException {
            if (cursor == null) throw new NoSuchElementException("nothing left");
            recent = cursor;           // element at this position might later be removed
            cursor = after(cursor);
            return recent;
        }

        /**
         * Removes the element returned by most recent call to next.
         *
         * @throws IllegalStateException if next has not yet been called
         * @throws IllegalStateException if remove was already called since recent next
         */
        public void remove() throws IllegalStateException {
            if (recent == null) throw new IllegalStateException("nothing to remove");
            LinkedPositionalList.this.remove(recent);         // remove from outer list
            recent = null;               // do not allow remove again until next is called
        }
    }

    private class PositionIterable implements Iterable<Position<E>> {
        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }

    @Override
    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }

    /* This class adapts the iteration produced by positions() to return elements. */
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = new PositionIterator();

        public boolean hasNext() {
            return posIterator.hasNext();
        }

        public E next() {
            return posIterator.next().getElement();
        } // return element!

        public void remove() {
            posIterator.remove();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    static class Node<E> implements Position<E> {
        LinkedPositionalList.Node<E> prev;
        E element;
        LinkedPositionalList.Node<E> next;

        public Node(LinkedPositionalList.Node<E> prev, E element, LinkedPositionalList.Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public E getElement() throws IllegalStateException {
            if (next == null) {
                throw new IllegalStateException();
            }
            return element;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = header.next;
        while (walk != tailer) {
            sb.append(walk.getElement());
            walk = walk.next;
            if (walk != tailer)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
}
