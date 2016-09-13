package me.zhang.rx.example;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

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
                System.out.println("Completed");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        myObservable.subscribe(mySubscriber);

        // Outputs:
        //  "Hello, world!"
        //  "Completed"

        Observable<String> just = Observable.just("Hello, world!");

        Action1<String> onNextAction = System.out::println;
        Action1<Throwable> onErrorAction = throwable -> System.out.println("Error");
        Action0 onCompleteAction = () -> System.out.println("Completed");

        just.subscribe(onNextAction, onErrorAction, onCompleteAction);
    }

}
