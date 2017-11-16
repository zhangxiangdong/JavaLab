package me.zhang.coreJava.generic;

/**
 * Created by zhangxiangdong on 2017/11/16.
 */
public class MyNode extends Node<Integer> {

    public MyNode(Integer data) {
        super(data);
    }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }

}
