package me.zhang.dataStructure;

/**
 * Created by zhangxiangdong on 2017/6/8.
 */
public interface Deque<E> {

    void addFirst(E e);

    E first();

    E removeFirst();

    void addLast(E e);

    E last();

    E removeLast();

    int size();

    boolean isEmpty();

}
