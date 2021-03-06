package me.zhang.rx;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by zhangxiangdong on 2017/4/21.
 */
public class RxDemo {

    public static void main(String[] args) {
//        Observable<Integer> source = Observable.range(1, 9);
//        Subscriber<Integer> consumer = new Subscriber<Integer>() {
//            @Override
//            public void onCompleted() {
//                System.out.println("Completed.");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                System.out.println("Integer -> " + integer);
//            }
//        };
//        source.subscribe(consumer);
//
//        source.subscribe(integer -> System.out.println("Number -> " + integer), Throwable::printStackTrace,
//                () -> System.out.println("Completed."));

        // ******************************************************************

//        Observable
//                .create((Observable.OnSubscribe<String>) subscriber -> {
//                    try {
//                        String result = doSomeTimeTakingIoOperation();
//                        subscriber.onNext(result);    // Pass on the data to subscriber
//                        subscriber.onCompleted();     // Signal about the completion subscriber
//                    } catch (Exception e) {
//                        subscriber.onError(e);        // Signal about the error to subscriber
//                    }
//                })
//                .subscribe(new Subscriber<String>() {
//
//                    @Override
//                    public void onStart() {
//                        super.onStart();
//                        System.out.println("Waiting for result...");
//                    }
//
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("Done.");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("\t" + s);
//                    }
//                });
//
//        Observable
//                .fromCallable(RxDemo::doSomeTimeTakingIoOperation)
//                .subscribe(new Subscriber<String>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("\t" + s);
//                    }
//                });

        Observable
                .zip(
                        Observable.fromCallable(RxDemo::doSomeTimeTakingIoOperation).subscribeOn(Schedulers.io()),
                        Observable.fromCallable(RxDemo::anotherTimeTakingNetworkRequest).subscribeOn(Schedulers.io()),
                        (s1, s2) -> s1 + " -- " + s2
                )
                .toBlocking()
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {
                        System.out.println("Completed.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("\t" + s);
                    }
                });
    }

    private static String doSomeTimeTakingIoOperation() {
        System.out.println("-> " + Thread.currentThread().getName());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Results from Mars!";
    }

    private static String anotherTimeTakingNetworkRequest() {
        System.out.println("-> " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello from network.";
    }

}
