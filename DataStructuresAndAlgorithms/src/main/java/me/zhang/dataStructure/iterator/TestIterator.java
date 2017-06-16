package me.zhang.dataStructure.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by zhangxiangdong on 2017/6/16.
 */
public class TestIterator {

    public void removeNegativeNumbers(ArrayList<Integer> numbers) {
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 0) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        TestIterator tester = new TestIterator();
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(-3, -2, -1, 0, 1, 2, 3));
        System.out.println(numbers);
        tester.removeNegativeNumbers(numbers);
        System.out.println(numbers);
    }

}
