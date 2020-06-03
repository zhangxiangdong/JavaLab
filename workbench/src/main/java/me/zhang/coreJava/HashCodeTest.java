package me.zhang.coreJava;


import org.jetbrains.annotations.NotNull;

/**
 * Created by Zhang on 10/11/2017 8:39 PM.
 */
public class HashCodeTest {

    public static void main(String[] args) {
        System.out.println("a".hashCode());
        System.out.println("b".hashCode());
        System.out.println("c".hashCode());

        String s = "Ok";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode() + "\t" + toString(sb));

        //noinspection StringOperationCanBeSimplified
        String t = new String("Ok");
        StringBuilder tb = new StringBuilder(t);
        System.out.println(t.hashCode() + "\t" + toString(tb));
    }

    private static String toString(@NotNull Object obj) {
        return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
    }

}
