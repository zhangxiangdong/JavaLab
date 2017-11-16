package me.zhang.coreJava.generic;

/**
 * Created by zhangxiangdong on 2017/11/16.
 */
public class Node<T> {

    public T data;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }

}
