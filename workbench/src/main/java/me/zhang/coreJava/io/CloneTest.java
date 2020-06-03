package me.zhang.coreJava.io;

import me.zhang.coreJava.Employee;

/**
 * Created by zhangxiangdong on 2017/12/20.
 */
public class CloneTest {

    public static void main(String[] args) {
        Employee carl = new Employee("Carl Cracker", 100_000, 2013, 5, 3);
        System.out.println(System.identityHashCode(carl));
        System.out.println(carl);
        carl = carl.serialClone();
        System.out.println(System.identityHashCode(carl));
        System.out.println(carl);
    }

}
