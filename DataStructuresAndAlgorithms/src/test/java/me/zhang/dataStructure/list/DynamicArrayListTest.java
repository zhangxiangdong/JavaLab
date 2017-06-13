package me.zhang.dataStructure.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/6/13.
 */
public class DynamicArrayListTest {

    @Test
    public void testDynamicality() {
        List<Integer> list = new DynamicArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add(i, i);
        }
        Assert.assertEquals(200, list.size());

        for (int i = 0; i < 100; i++) {
            list.remove(i);
        }
        for (int i = 0; i < 50; i++) {
            list.remove(i);
        }
        Assert.assertEquals(50, list.size());
    }

}