package com.zhang.creational.pool;

/**
 * Created by zhangxiangdong on 2016/11/28.
 * <p>
 * Heavy object.
 */
public class Titanic {

    private static int counter = 1;
    private final int id;

    public Titanic() {
        try {
            Thread.sleep(1000); // Titanic is too heavy to create
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.id = counter++; // Object flag
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Titanic{" +
                "id=" + id +
                '}';
    }
}
