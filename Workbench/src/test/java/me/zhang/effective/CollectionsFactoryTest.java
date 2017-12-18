package me.zhang.effective;

import me.zhang.effective.item1.CollectionsFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangxiangdong on 2017/12/18.
 */
public class CollectionsFactoryTest {

    @Test
    public void newArrayList() {
        List<String> newArrayList = CollectionsFactory.newArrayList();
        Assert.assertTrue(newArrayList instanceof ArrayList);
    }

    @Test
    public void newHashMap() {
        Map<String, String> newHashMap = CollectionsFactory.newHashMap();
        Assert.assertTrue(newHashMap instanceof HashMap);
    }
}