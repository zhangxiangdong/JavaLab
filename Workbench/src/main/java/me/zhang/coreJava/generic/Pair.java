package me.zhang.coreJava.generic;

/**
 * Created by zhangxiangdong on 2017/11/13.
 */
public class Pair<T> {

    private T first;
    private T second;

    public Pair() {
        first = second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public static void main(String[] args) {
        Pair<String> stringPair = new Pair<>();
        stringPair.setFirst("A");
        stringPair.setSecond("B");
        System.out.println(stringPair.getFirst() + ":" + stringPair.getSecond());
    }

}
