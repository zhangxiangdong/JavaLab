package me.zhang.annotation;

/**
 * Created by Zhang on 2018/5/13 13:14.
 */
@Author(name = "Zhang")
@SuppressWarnings("unused")
public class MyClass {

    public int i;

    @SuppressWarnings(value = "unused")
    void myMethod(Object aString) {
    }

    @Author(name = "Thompson")
    void mySuperMethod() {
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}

@ClassPreamble(
        author = "Xiangdong",
        date = "2018/5/13",
        lastModified = "2018/5/13",
        lastModifiedBy = "Zhang",
        reviewers = {"Zhang", ""}
)
class Example {

}
