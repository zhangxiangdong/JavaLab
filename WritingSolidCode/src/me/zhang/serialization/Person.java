package me.zhang.serialization;

import java.io.Serializable;

/**
 * Created by Zhang on 2015/6/12 上午 11:22 .
 * <p>
 * 反序列化时final变量在以下情况下不会被重新赋值：
 * <li>通过构造函数为final变量赋值</li>
 * <li>通过方法返回值为final变量赋值</li>
 * <li>final修饰的属性不是基本类型</li>
 */
public class Person implements Serializable {

    /* Without serialVersionUID, InvalidClassException would happen */
    private static final long serialVersionUID = 8878115410154075242L;

    private String name;

    private final int sex;

    private final int age = initAge();

    /* 通过方法赋值final变量，反序列化的获取获取不到最新的值 */
    /* 原因：类描述信息不记录方法、构造函数、static变量等的具体实现 */
    private int initAge() {
        /* default age */
        // return 18;
        return 22;
    }

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    //    private int age;
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* 在序列化类中，不要使用构造函数为final变量赋值 */
    public Person() {
        sex = 2;
    }
}
