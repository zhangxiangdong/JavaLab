package me.zhang.demo;

import java.util.Optional;

/**
 * Created by zhangxiangdong on 2017/5/10.
 */
public class GenericTester<T> {

    public static void main(String[] args) {
        GenericTester<Integer> genericTester = new GenericTester<>();
        Optional<Integer> optional = genericTester.findById("Hi");
        optional.ifPresent(System.out::println);
    }

    private Optional<T> findById(Object key) {
        return Optional.ofNullable((T) key);
    }

}
