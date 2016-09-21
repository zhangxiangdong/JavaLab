package me.zhang.rx.example;

import rx.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiangdong on 2016/9/13.
 */
class Provider {

    // Returns the title of a website, or null if 404
    static Observable<String> getTitle(String URL) {
        String title = "MyTitle";
        if ("http://www.title.com/".equals(URL)) {
            return Observable.from(new String[]{title});

        }
        return Observable.from(new String[]{null});
    }

    // Returns a List of website URLs based on a text search
    static Observable<List<String>> query(String text) {
        List<String> urlList = new ArrayList<>();
        urlList.add("url1" + text);
        urlList.add("http://www.title.com/");
        urlList.add("http://www.title.com/");
        urlList.add("url4" + text);
        urlList.add("url5");

        List<List<String>> urlsList = new ArrayList<>();
        urlsList.add(urlList);
        return Observable.from(urlsList).map(urls -> urls);
    }

}
