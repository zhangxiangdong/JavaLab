package me.zhang.generic;

/**
 * Created by zhangxiangdong on 2017/4/25.
 */
public class Utility {

    /**
     * @param sequence to be reversed.
     * @param <T>      modifier to declare the method to be generic.
     */
    public static <T> void reverse(T[] sequence) {
        int low = 0, high = sequence.length - 1;
        while (low < high) {
            T element = sequence[low];
            sequence[low++] = sequence[high];
            sequence[high--] = element;
        }
    }

    public static <T extends Number> T compare(T left, T right) {
        T result;
        if (left.intValue() > right.intValue()) {
            result = (T) new Integer(1);
        } else if (left.intValue() == right.intValue()) {
            result = (T) new Integer(0);
        } else {
            result = (T) new Integer(-1);
        }
        return result;
    }

}
