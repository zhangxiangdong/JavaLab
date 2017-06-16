package me.zhang.dataStructure.iterator;

import me.zhang.dataStructure.list.ArrayList;

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
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            numbers.add(i + 3, i);
        }
        System.out.println(numbers);
        tester.removeNegativeNumbers(numbers);
        System.out.println(numbers);
    }

}
