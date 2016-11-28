package com.zhang.pool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiangdong on 2016/11/28.
 */
public abstract class ObjectPool<T> {

    static final String poolPattern = "Pool: available = %d, inUse = %d.";
    private List<T> available = new ArrayList<>();
    private List<T> inUse = new ArrayList<>();

    protected abstract T create();

    public T checkOut() {
        if (available.size() == 0) {
            available.add(create());
        }
        int last = available.size() - 1;
        T instance = available.get(last);
        available.remove(instance); // Checkout the last one
        inUse.add(instance);

        System.out.println(toString());
        return instance;
    }

    public void checkIn(T instance) {
        inUse.remove(instance);
        available.add(instance);

        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format(poolPattern, available.size(), inUse.size());
    }

}
