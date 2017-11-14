package me.zhang.coreJava.generic;

import java.io.Serializable;

/**
 * Created by zhangxiangdong on 2017/11/14.
 */
public class Interval<T extends Comparable & Serializable> implements Serializable {

    private T lower;
    private T upper;

    public Interval() {
    }

    public Interval(T lower, T upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public T getLower() {
        return lower;
    }

    public void setLower(T lower) {
        this.lower = lower;
    }

    public T getUpper() {
        return upper;
    }

    public void setUpper(T upper) {
        this.upper = upper;
    }

}
