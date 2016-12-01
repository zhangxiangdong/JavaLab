package com.zhang.structural.bridge;

/**
 * Created by zhangxiangdong on 2016/12/1.
 */
abstract public class Shape {

    // Composition - implementor
    protected Color color;

    // constructor with implementor as input argument
    public Shape(Color c) {
        this.color = c;
    }

    abstract void withColor();

}
