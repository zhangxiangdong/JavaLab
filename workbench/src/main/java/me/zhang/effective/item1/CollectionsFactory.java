package me.zhang.effective.item1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangxiangdong on 2017/12/18.
 */
public class CollectionsFactory {

    private CollectionsFactory() {
    }

    public static <E> List<E> newArrayList() {
        return new ArrayList<>();
    }

    public static <K, V> Map<K, V> newHashMap() {
        return new HashMap<>();
    }

    // ...

}
