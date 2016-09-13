package me.zhang.rx.example;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by zhangxiangdong on 2016/9/13.
 */
public class ObservableTestDrive {

    public static void main(String[] args) {
        Observable<String> myObservable = Observable.create(
                subscriber -> {
                    subscriber.onNext("Hello, world!");
                    subscriber.onCompleted();
                }
        );

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        myObservable.subscribe(mySubscriber);

        // Outputs "Hello, world!"
    }

}
