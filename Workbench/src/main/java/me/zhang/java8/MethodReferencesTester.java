package me.zhang.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiangdong on 2017/4/25.
 */
public class MethodReferencesTester {

    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("Lucy");
        nameList.add("Tim");
        nameList.add("Dolly");
        nameList.add("Luca");
        nameList.add("Grili");

        nameList.forEach(System.out::println);
    }

}
