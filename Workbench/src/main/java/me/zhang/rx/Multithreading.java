package me.zhang.rx;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.concurrent.Callable;

/**
 * Created by zhangxiangdong on 2017/4/24.
 */
public class Multithreading {

    public static void main(String[] args) {
        Observable.fromCallable(thatReturnsNumberOne())     // the Observable
                .map(numberToString())                      // the Operator
                .subscribe(printResult());                  // the Subscriber
    }

    private static Callable<Integer> thatReturnsNumberOne() {
        return () -> {
            System.out.println("Observable thread: " + Thread.currentThread().getName());
            return 1;
        };
    }

    private static Func1<Integer, String> numberToString() {
        return number -> {
            System.out.println("Operator thread: " + Thread.currentThread().getName());
            return String.valueOf(number);
        };
    }

    private static Action1<String> printResult() {
        return result -> {
            System.out.println("Subscriber thread: " + Thread.currentThread().getName());
            System.out.println("Result: " + result);
        };
    }

}
