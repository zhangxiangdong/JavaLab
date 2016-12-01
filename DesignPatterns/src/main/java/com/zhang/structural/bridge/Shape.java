package com.zhang.structural.bridge;

/**
 * Created by zhangxiangdong on 2016/12/1.
 */
abstract public class Shape implements Stainable {

    // Composition - implementor
    protected Stainable stainable;

    // constructor with implementor as input argument
    public Shape(Stainable c) {
        this.stainable = c;
    }

}
