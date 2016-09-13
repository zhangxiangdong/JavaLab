package me.zhang.rx.example;

import rx.Observable;

/**
 * Created by zhangxiangdong on 2016/9/13.
 */
public class OperatorsTestDrive {

    public static void main(String[] args) {
        Observable.just("Hello ").map(s -> s + "Zhang").subscribe(System.out::println);
    }

}
