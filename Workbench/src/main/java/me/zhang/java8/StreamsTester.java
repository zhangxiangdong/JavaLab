package me.zhang.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhangxiangdong on 2017/5/3.
 */
public class StreamsTester {

    public static void main(String[] args) {
        List<String> input = Arrays.asList("A", "", "Good", "Example", "", "!");
        List<String> output = input.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());

        output.forEach(System.out::println);
    }

}
