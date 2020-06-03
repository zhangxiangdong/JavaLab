package me.zhang.java.tutorials.annotations;

import java.lang.annotation.Documented;

/**
 * Created by zhangxiangdong on 2018/1/23.
 */
public class AnnotationsTest {

    @Author(
            name = "Lei Li",
            date = "1/23/2018",
            reviewers = {"Tommy", "Luca", "Anderson"}
    )
    static class Class {
        public String name;
    }

}

@Documented
@interface Author {

    String name() default "Anonymous";

    String date();

    String[] reviewers();

}
