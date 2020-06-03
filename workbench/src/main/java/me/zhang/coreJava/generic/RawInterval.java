package me.zhang.coreJava.generic;

import java.io.Serializable;

/**
 * Created by zhangxiangdong on 2017/11/14.
 * <p>
 * Raw type of {@link Interval}.
 */
public class RawInterval implements Serializable {

    private Comparable lower;
    private Comparable upper;

    public RawInterval() {
    }

    public RawInterval(Comparable lower, Comparable upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public Comparable getLower() {
        return lower;
    }

    public void setLower(Comparable lower) {
        this.lower = lower;
    }

    public Comparable getUpper() {
        return upper;
    }

    public void setUpper(Comparable upper) {
        this.upper = upper;
    }

}
