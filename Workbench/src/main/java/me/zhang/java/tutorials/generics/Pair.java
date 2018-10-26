package me.zhang.java.tutorials.generics;

/**
 * Created by zhangxiangdong on 2018/10/26 10:10.
 */
public class Pair<K, V> {

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    private K key;
    private V value;
}
