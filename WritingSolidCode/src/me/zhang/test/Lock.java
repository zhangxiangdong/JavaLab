package me.zhang.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zhang on 2015/12/28 下午 2:59 .
 */
public class Lock {

    private final List<String> list = Collections.synchronizedList(new ArrayList<String>());

    private void query() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        this.list.addAll(list);
    }

    private void show() {
        System.out.println(list);
    }

    public static void main(String[] args) {
        final Lock lock = new Lock();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock.list) {
                        Thread.sleep(3000);
                        lock.query();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis());
                lock.show();
                System.out.println(System.currentTimeMillis());
            }
        });

        threadA.start();
        threadB.start();
    }

}
