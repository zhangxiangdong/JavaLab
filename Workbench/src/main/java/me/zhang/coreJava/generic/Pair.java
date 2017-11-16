package me.zhang.coreJava.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by zhangxiangdong on 2017/11/13.
 */
public class Pair<T> {

    private T first;
    private T second;

    public Pair() {
        first = second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public <X> Pair(X x) { // declare its own formal type parameters (not T here)
        System.out.println(x);
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public static <T> Pair<T> newPair(Class<T> cls) {
        try {
            return new Pair<>(cls.newInstance(), cls.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Pair<String> stringPair = new Pair<>();
        stringPair.setFirst("A");
        stringPair.setSecond("B");
        System.out.println(stringPair.getFirst() + ":" + stringPair.getSecond());

        Pair<Double> d = new Pair<>();
        /* 运行时类型检查只适用于原始类型 */
        // ERROR: d instanceof Pair<Double>
        if (d instanceof Pair) {
            System.out.println("d is a Pair");
        }

        Pair a = new Pair();
        a.setFirst("M");
        a.setSecond("N");
        Pair<String> sA = (Pair<String>) a;
        System.out.println(sA.getFirst() + ":" + sA.getSecond());

        // Pair<Integer>[] pairs = new Pair<Integer>[10]; // ERROR!
        Pair<Integer>[] pairs = (Pair<Integer>[]) new Pair<?>[3]; // unsafe!!!
        Pair<Integer> pair1 = new Pair<>(-1, 1);
        Pair<Integer> pair2 = new Pair<>(-2, 2);
        Pair<Integer> pair3 = new Pair<>(-3, 3);
        pairs[0] = pair1;
        pairs[1] = pair2;
        pairs[2] = pair3;
        System.out.println(Arrays.deepToString(pairs));

        // safe way
        List<Pair<Integer>> pairList = new ArrayList<>();
//        pairList.add(pair1);
//        pairList.add(pair2);
//        pairList.add(pair3);
        addAll(pairList, pair1, pair2, pair3);
        System.out.println(Arrays.deepToString(pairList.toArray()));

        Pair<String> newPair = newPair(String.class);
        if (newPair != null) {
            newPair.setFirst("X");
            newPair.setSecond("Y");
            System.out.println(newPair.getFirst() + ":" + newPair.getSecond());
        }

        Pair<Integer> p = new Pair<>("Hello");
    }

    @SafeVarargs
    private static <T> void addAll(Collection<T> container, T... ts) {
        container.addAll(Arrays.asList(ts));
    }

}
