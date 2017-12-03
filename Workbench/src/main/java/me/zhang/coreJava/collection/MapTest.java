package me.zhang.coreJava.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Zhang on 12/3/2017 1:02 PM.
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map.get(null));

        Set<String> keys = map.keySet();
        Collection<String> values = map.values();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        System.out.println(keys);
        System.out.println(values);
        System.out.println(entries);
    }

}
