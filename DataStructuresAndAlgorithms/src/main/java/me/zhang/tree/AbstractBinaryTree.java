package me.zhang.tree;

import me.zhang.dataStructure.list.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiangdong on 2017/7/4.
 * <p>
 * An abstract base class providing some functionality of the BinaryTree interface.
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = parent(p);
        if (parent == null) { // p must be the root
            return null;
        }
        if (p == left(parent)) { // p is a left child
            return right(parent); // (right child might be null)
        } else { // p is a right child
            return left(parent); // (left child might be null)
        }
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null) {
            snapshot.add(left(p));
        }
        if (right(p) != null) {
            snapshot.add(right(p));
        }
        return snapshot;
    }

    /**
     * Returns an iterable collection of the positions of the tree using inorder traversal
     *
     * @return iterable collection of the tree's positions using inorder traversal
     */
    @Override
    public Iterable<Position<E>> positions() {
        return inorder();
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in inorder.
     *
     * @return iterable collection of the tree's positions reported in inorder
     */
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            inorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    /**
     * Adds positions of the subtree rooted at Position p to the given
     * snapshot using an inorder traversal
     *
     * @param p        Position serving as the root of a subtree
     * @param snapshot a list to which results are appended
     */
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null) {
            inorderSubtree(left(p), snapshot);
        }
        snapshot.add(p);
        if (right(p) != null) {
            inorderSubtree(right(p), snapshot);
        }
    }

}
