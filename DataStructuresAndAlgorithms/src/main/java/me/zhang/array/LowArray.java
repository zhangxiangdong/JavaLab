package me.zhang.array;

/**
 * Created by Zhang on 2015/11/20 下午 3:45 .
 */
public class LowArray {

    private long[] a;

    public LowArray(int size) {
        a = new long[size];
    }

    public void setElem(int index, long value) {
        a[index] = value;
    }

    public long getElem(int index) {
        return a[index];
    }

}
