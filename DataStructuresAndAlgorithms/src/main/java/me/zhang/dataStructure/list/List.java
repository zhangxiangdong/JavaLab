package me.zhang.dataStructure.list;

/**
 * Created by zhangxiangdong on 2017/6/9.
 */
public interface List<E> {

    void add(int i, E e) throws IndexOutOfBoundsException;

    E remove(int i) throws IndexOutOfBoundsException;

    void set(int i, E e) throws IndexOutOfBoundsException;

    E get(int i) throws IndexOutOfBoundsException;

    int size();

    boolean isEmpty();

}
