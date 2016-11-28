package com.zhang.creational.pool;

/**
 * Created by zhangxiangdong on 2016/11/28.
 */
public class App {

    public static void main(String[] args) {
        ObjectPool<Titanic> titanicObjectPool = new TitanicPool();
        Titanic titanic1 = titanicObjectPool.checkOut();
        System.out.println(titanic1);

        Titanic titanic2 = titanicObjectPool.checkOut();
        System.out.println(titanic2);
        titanicObjectPool.checkIn(titanic1);

        Titanic titanic3 = titanicObjectPool.checkOut();
        System.out.println(titanic3);

        titanicObjectPool.checkIn(titanic2);
        titanicObjectPool.checkIn(titanic3);
    }

}
