package com.zhang.creational.pool;

/**
 * Created by zhangxiangdong on 2016/11/28.
 */
public class TitanicPool extends ObjectPool<Titanic> {

    @Override
    protected Titanic create() {
        return new Titanic();
    }

}
