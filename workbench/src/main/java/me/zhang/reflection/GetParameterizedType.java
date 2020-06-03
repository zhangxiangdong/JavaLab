package me.zhang.reflection;

import java.lang.reflect.ParameterizedType;
import java.util.function.IntFunction;

/**
 * Created by zhangxiangdong on 2019/8/21 9:32.
 */
public class GetParameterizedType {

    public static void main(String[] args) {
        insert(1, new IntFunction<Integer>() {
            @Override
            public Integer apply(int value) {
                return 1;
            }
        });
        insert(2, new IntFunction<Float>() {
            @Override
            public Float apply(int value) {
                return 2F;
            }
        });
        insert(3, new IntFunction<Long>() {
            @Override
            public Long apply(int value) {
                return 3L;
            }
        });
    }

    private static <R> void insert(int value, IntFunction<R> function) {
        System.out.println(((ParameterizedType) function.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0].getTypeName());
    }

}
