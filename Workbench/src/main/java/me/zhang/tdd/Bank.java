package me.zhang.tdd;

/**
 * Created by zhangxiangdong on 2017/3/1.
 */
public class Bank {

    public Money reduce(Expression source, String to) {
        return source.reduce(to);
    }

}
