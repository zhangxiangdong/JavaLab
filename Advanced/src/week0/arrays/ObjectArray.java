package week0.arrays;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Zhang on 9/27/2015 12:30 下午.
 */
public class ObjectArray {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("First");
        set.add("Second");
        set.add("First");
        System.out.println(set);

        System.out.println("***************************");

        ArrayList<String> list = new ArrayList<>();
        list.add("First");
        list.add("Second");
        list.add("First");
        System.out.println(list);

        System.out.println("***************************");

        Value[] values = new Value[3];
        for (int i = 0; i < values.length; i++) {
            Value value = new Value();
            value.id = i;
            value.value = "value: " + i;
            values[i] = value;
        }

        for (Value v : values) {
            if (v.id == 1) {
                v.value = "VALUE: 1";
            }
            System.out.println(v.id);
            System.out.println(v.value);
        }

    }

}

class Value {

    public int id;

    public String value;

}