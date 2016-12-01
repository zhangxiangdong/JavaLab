package com.zhang.structural.bridge;

/**
 * Created by zhangxiangdong on 2016/12/1.
 */
abstract public class Shape {

    /**
     * Notice the bridge between Shape and Color interfaces and use of composition in implementing the bridge pattern.
     */
    // Composition - implementor
    protected Color color;

    // constructor with implementor as input argument
    public Shape(Color c) {
        this.color = c;
    }

    abstract void withColor();

}
