package com.zhang.creational.factory.abs;

/**
 * Created by zhangxiangdong on 2016/11/21.
 */
public abstract class AbstractFactory<T> {

    public abstract T get(String t);

}
