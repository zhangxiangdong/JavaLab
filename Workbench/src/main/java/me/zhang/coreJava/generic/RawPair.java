package me.zhang.coreJava.generic;

/**
 * Created by zhangxiangdong on 2017/11/14.
 */
public class RawPair {

    private Object first;
    private Object second;

    public RawPair() {
        first = second = null;
    }

    public RawPair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public Object getSecond() {
        return second;
    }

    public void setSecond(Object second) {
        this.second = second;
    }

    public static void main(String[] args) {
        RawPair stringPair = new RawPair("A", "B");
        System.out.println(stringPair.getFirst() + ":" + stringPair.getSecond());
    }

}
