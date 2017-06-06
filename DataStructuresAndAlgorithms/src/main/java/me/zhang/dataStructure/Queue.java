package me.zhang.dataStructure;

/**
 * Created by zhangxiangdong on 2017/6/6.
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E first();

    int size();

    boolean isEmpty();

}
