package me.zhang.coreJava;

/**
 * Created by zhangxiangdong on 2017/10/9.
 */
public class Student extends Person {

    public Student(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "A student majoring in computer science";
    }

}
