package me.zhang.dataStructure;

/**
 * Created by zhangxiangdong on 2017/6/2.
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    boolean isEmpty();

    E top();

    int size();

}
