package me.zhang.dataStructure.list;

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

}
