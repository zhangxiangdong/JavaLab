package me.zhang.offer;

import me.zhang.dsa.AutoSortArrayList;
import me.zhang.dsa.AutoSortList;
import org.junit.Test;

/**
 * Created by Zhang on 8/27/2017 12:50 PM.
 */
public class Q30Test {

    @Test
    public void testAutoSortContainer() {
        AutoSortList<Integer> sortedContainer = new AutoSortArrayList<>();
        sortedContainer.add(3);
        sortedContainer.add(2);
        sortedContainer.add(1);
        sortedContainer.add(1);
        sortedContainer.add(4);
        sortedContainer.add(5);
        System.out.println(sortedContainer);
    }

}