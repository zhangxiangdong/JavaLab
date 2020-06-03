package me.zhang.coreJava.generic;

/**
 * Created by zhangxiangdong on 2017/11/16.
 * <p>
 * https://docs.oracle.com/javase/tutorial/java/generics/bridgeMethods.html
 */
public class NodeTest {

    public static void main(String[] args) {
        MyNode mn = new MyNode(5);
        Node n = mn;            // A raw type - compiler throws an unchecked warning
        // n.setData("Hello");     // Causes a ClassCastException to be thrown.
        n.setData(4);
        Integer x = mn.data;
        System.out.println(x);
    }

}
