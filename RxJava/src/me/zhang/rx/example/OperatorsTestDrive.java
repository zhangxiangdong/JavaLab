package me.zhang.rx.example;

import rx.Observable;

/**
 * Created by zhangxiangdong on 2016/9/13.
 */
public class OperatorsTestDrive {

    public static void main(String[] args) {
        Observable.just("Hello").map(s -> s + "-Zhang").subscribe(System.out::println);

        /* Output the hash of the text: "World" */
        Observable.just("World")
                .map(s -> s + "-Zhang")
                .map(String::hashCode)
                .map(i -> "HashCode: " + String.valueOf(i))
                .subscribe(System.out::println);

        Provider.query("Hi").subscribe(urls -> urls.forEach(System.out::println));
        Provider.query("He").subscribe(urls -> Observable.from(urls).subscribe(System.out::println)); // Ugh.

        Provider.query("+do")
                .flatMap(Observable::from)
                .flatMap(Provider::getTitle)
                .filter(title -> title != null)
                .take(1)
                .doOnNext(title -> System.out.println("Got this: " + title))
                .subscribe(System.out::println);
    }

}
