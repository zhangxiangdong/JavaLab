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

}
