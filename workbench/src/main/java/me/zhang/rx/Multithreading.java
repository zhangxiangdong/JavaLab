package me.zhang.rx;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.concurrent.Callable;

/**
 * Created by zhangxiangdong on 2017/4/24.
 * <p>
 * https://praveer09.github.io/technology/2016/02/29/rxjava-part-3-multithreading/
 */
public class Multithreading {

    public static void main(String[] args) {
//        defaultThreading();
//        operatorOnDifferentThread();
//        subscriberOnDifferentThread();
//        bothOperatorAndSubscriberOnDifferntThread();

        subscribeOn();

        try {
            // Wait
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void defaultThreading() {
        Observable.fromCallable(thatReturnsNumberOne())     // the Observable
                .map(numberToString())                      // the Operator
                .subscribe(printResult());                  // the Subscriber
    }

    private static void operatorOnDifferentThread() {
        Observable.fromCallable(thatReturnsNumberOne())
                .observeOn(Schedulers.newThread())      // operator on different thread
                .map(numberToString())
                .subscribe(printResult());
    }

    private static void subscriberOnDifferentThread() {
        Observable.fromCallable(thatReturnsNumberOne())
                .map(numberToString())
                .observeOn(Schedulers.newThread())      // subscriber on different thread
                .subscribe(printResult());
    }

    private static void bothOperatorAndSubscriberOnDifferntThread() {
        Observable.fromCallable(thatReturnsNumberOne())
                .observeOn(Schedulers.newThread())      // operator on different thread
                .map(numberToString())
                .observeOn(Schedulers.newThread())      // subscriber on different thread
                .subscribe(printResult());
    }

    private static void subscribeOn() {
        Observable.fromCallable(thatReturnsNumberOne())
                .subscribeOn(Schedulers.newThread()) // only the first declaration takes preference
                .map(numberToString())
                .subscribeOn(Schedulers.newThread())
                .map(stringToNumber())
                .toBlocking()
                .subscribe(printNumberResult());
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

    private static Func1<String, Integer> stringToNumber() {
        return string -> {
            System.out.println("Operator thread: " + Thread.currentThread().getName());
            return Integer.parseInt(string);
        };
    }

    private static Action1<String> printResult() {
        return result -> {
            System.out.println("Subscriber thread: " + Thread.currentThread().getName());
            System.out.println("Result: " + result);
        };
    }

    private static Action1<Integer> printNumberResult() {
        return result -> {
            System.out.println("Subscriber thread: " + Thread.currentThread().getName());
            System.out.println("Result: " + result);
        };
    }

}
