package me.zhang.dataStructure.list;

/**
 * Created by zhangxiangdong on 2017/6/14.
 */
public interface Position<E> {

    /**
     * Returns the element stored at this position.
     *
     * @return the stored element
     * @throws IllegalStateException if position no longer valid
     */
    E getElement() throws IllegalStateException;

}
