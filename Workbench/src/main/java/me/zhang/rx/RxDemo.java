package me.zhang.rx;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by zhangxiangdong on 2017/4/21.
 */
public class RxDemo {

    public static void main(String[] args) {
        Observable<Integer> source = Observable.range(1, 9);
        Subscriber<Integer> consumer = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Completed.");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Integer -> " + integer);
            }
        };
        source.subscribe(consumer);

        source.subscribe(integer -> System.out.println("Number -> " + integer), Throwable::printStackTrace,
                () -> System.out.println("Completed."));
    }

}
