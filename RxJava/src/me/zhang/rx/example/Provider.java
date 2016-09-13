package me.zhang.rx.example;

import rx.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiangdong on 2016/9/13.
 */
class Provider {

    // Returns a List of website URLs based on a text search
    static Observable<List<String>> query(String text) {
        List<String> urlList = new ArrayList<>();
        urlList.add("url1" + text);
        urlList.add("url2");
        urlList.add("url3");
        urlList.add("url4" + text);
        urlList.add("url5");

        List<List<String>> urlsList = new ArrayList<>();
        urlsList.add(urlList);
        return Observable.from(urlsList).map(urls -> urls);
    }

}
