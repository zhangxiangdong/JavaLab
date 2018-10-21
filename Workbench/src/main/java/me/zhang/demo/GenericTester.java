package me.zhang.demo;

import java.util.*;

/**
 * Created by zhangxiangdong on 2017/5/10.
 */
public class GenericTester<T> {

    public static void main(String[] args) {
//        GenericTester<Integer> genericTester = new GenericTester<>();
//        Optional<Integer> optional = genericTester.findById("Hi");
//        optional.ifPresent(System.out::println);

        processStringList(Collections.<String>emptyList()); // works on java 7
        processStringList(Collections.emptyList()); // works on java 8+

        // process(new ArrayList<Integer>()); // compile error
        sumOfList(new ArrayList<Integer>());
        sumOfList(new ArrayList<Float>());
        System.out.println("sum = " + sumOfList(Arrays.asList(1, 2f, 3d)));

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
//        printList(integerList); // compile error!
        printList1(integerList);
        printList2(integerList);

        printNumbers(integerList);

        addNumbers(new ArrayList<Object>());

        ArrayList<Integer> out = new ArrayList<>(Arrays.asList(1, 2, 3));
        setter(out);
        System.out.println(out);

        System.out.println("************** PECS (Producer-Extends, Consumer-Super) ***************");

        List<? extends Number> numbers = new ArrayList<>(Arrays.asList(1, 2, 3)); /* Producer */
        Number number1 = numbers.get(0); // provide a number.
        System.out.println(number1);

        List<? super Integer> integers = new ArrayList<>(); /* Consumer */
        integers.add(1); // consume an integer.
        integers.add(2);
        integers.add(3);
        System.out.println(integers);
    }

    // https://docs.oracle.com/javase/tutorial/java/generics/capture.html

    //    private static void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
//        Number temp = l1.get(0);
//        l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
//        // got a CAP#2 extends Number;
//        // same bound, but different types
//        l2.set(0, temp);	    // expected a CAP#1 extends Number,
//        // got a Number
//    }

    private static void setter(List<?> out) {
        // out.set(0, out.get(0)); // error!
        setterHelper(out);
    }

    private static <T> void setterHelper(List<T> out) {
        out.set(0, out.get(1));
    }

    private static void addNumbers(List<? super Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    private static void printNumbers(List<? extends Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printList2(List<?> list) {
        list.add(null); // it's ok.
        // list.add("not allowed"); // compile error!
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    private static void printList1(List list) {
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    private static void printList(List<Object> list) {
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    private static void processStringList(List<String> stringList) {

    }

    private static void process(List<Number> numbers) {

    }

    private static double sumOfList(List<? extends Number> numbers) {
        double s = 0.0;
        for (Number n : numbers) {
            s += n.doubleValue();
        }
        return s;
    }

    private Optional<T> findById(Object key) {
        return Optional.ofNullable((T) key);
    }

}
