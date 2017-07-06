package me.zhang.tree;

import me.zhang.dataStructure.list.Position;

import java.util.Iterator;

/**
 * Created by zhangxiangdong on 2017/7/5.
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    protected Node<E> root;
    private int size;

    protected static class Node<E> implements Position<E> {

        Node<E> parent;
        Node<E> left;
        E element;
        Node<E> right;

        public Node(Node<E> parent, Node<E> left, E element, Node<E> right) {
            this.parent = parent;
            this.left = left;
            this.element = element;
            this.right = right;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }

    }

    /**
     * Factory function to create a new node storing element e.
     */
    protected Node<E> createNode(Node<E> parent, Node<E> left, E element, Node<E> right) {
        return new Node<>(parent, left, element, right);
    }

    /**
     * Verifies that a Position belongs to the appropriate class, and is
     * not one that has been previously removed. Note that our current
     * implementation does not actually verify that the position belongs
     * to this particular list instance.
     *
     * @param p a Position (that should belong to this tree)
     * @return the underlying Node instance for the position
     * @throws IllegalArgumentException if an invalid position is detected
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type");
        }
        Node<E> node = (Node<E>) p;
        if (node.parent == node) { // convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        }
        return node;
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        return validate(p).left;
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        return validate(p).right;
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        return validate(p).parent;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Places element e at the root of an empty tree and returns its new Position.
     *
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = createNode(null, null, e, null);
        size = 1;
        return root;
    }

    /**
     * Creates a new left child of Position p storing element e and returns its Position.
     *
     * @param p the Position to the left of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p already has a left child
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.left != null) {
            throw new IllegalArgumentException("p already has a left child");
        }
        Node<E> leftChild = createNode(parent, null, e, null);
        parent.left = leftChild;
        size++;
        return leftChild;
    }

    /**
     * Creates a new right child of Position p storing element e and returns its Position.
     *
     * @param p the Position to the right of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p already has a right child
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.right != null) {
            throw new IllegalArgumentException("p already has a right child");
        }
        Node<E> rightChild = createNode(parent, null, e, null);
        parent.right = rightChild;
        size++;
        return rightChild;
    }

    /**
     * Replaces the element at Position p with element e and returns the replaced element.
     *
     * @param p the relevant Position
     * @param e the new element
     * @return the replaced element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E element = node.element;
        node.element = e;
        return element;
    }

    /**
     * Attaches trees t1 and t2, respectively, as the left and right subtree of the
     * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
     *
     * @param p  a leaf of the tree
     * @param t1 an independent tree whose structure becomes the left child of p
     * @param t2 an independent tree whose structure becomes the right child of p
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p is not a leaf
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) {
            throw new IllegalArgumentException("p is not a leaf");
        }
        size += t1.size + t2.size;
        if (!t1.isEmpty()) {
            t1.root.parent = node;
            node.left = t1.root;
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) {
            t2.root.parent = node;
            node.right = t2.root;
            t2.root = null;
            t2.size = 0;
        }
    }

    /**
     * Removes the node at Position p and replaces it with its child, if any.
     *
     * @param p the relevant Position
     * @return element that was removed
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p has two children.
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("p has two children");
        }
        Node<E> child = node.left != null ? node.left : node.right;
        if (child != null) {
            child.parent = node.parent; // child's grandparent becomes its parent
        }
        if (node == root) {
            root = child; // child becomes root
        } else {
            Node<E> parent = node.parent;
            if (node == parent.left)
                parent.left = child;
            else
                parent.right = child;
        }
        size--;
        E element = node.element;
        node.element = null;
        node.left = null;
        node.right = null;
        node.parent = node; // convention for defunct node
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

}
