package me.zhang.string;

import java.util.Arrays;

/**
 * Created by Zhang on 7/29/2017 2:02 PM.
 * <p>
 * 实现一个函数，把字符串中的每个空格替换成“%20”。例如输入“We are happy.”，则输出“We%20are%20happy.”。
 */
public class Replacement {

    public static void main(String[] args) {
        String original = "We are happy.";
        System.out.println(original);

        String newString = replaceBlankWithStringBuilder(original);
        System.out.println(newString);

        newString = replaceBlankWithTwoPointers(original);
        System.out.println(newString);
    }

    static String replaceBlankWithTwoPointers(String original) {
        // 0. Check null pointer.
        if (original == null) {
            throw new NullPointerException();
        }

        // 1. Caculate number of spaces.
        int numOfSpaces = 0;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == ' ') {
                numOfSpaces++;
            }
        }

        // 2. Prepare new array of chars.
        char[] newChars = new char[original.length() + numOfSpaces * 2];
        char[] originalChars = original.toCharArray();
        System.arraycopy(originalChars, 0, newChars, 0, originalChars.length);
        // Print out new array of chars.
        System.out.println(Arrays.toString(newChars));

        // 3. Do replacement(Move & Insert).
        int indexOfOriginal = originalChars.length - 1;
        int indexOfNew = newChars.length - 1;
        while (indexOfOriginal >= 0 && indexOfOriginal < indexOfNew) {
            if (newChars[indexOfOriginal] == ' ') {
                newChars[indexOfNew--] = '0';
                newChars[indexOfNew--] = '2';
                newChars[indexOfNew--] = '%';
            } else {
                newChars[indexOfNew--] = newChars[indexOfOriginal];
            }
            indexOfOriginal--;
        }

        // 4. Concatenate chars to a single string.
        System.out.println(Arrays.toString(newChars));
        StringBuilder builder = new StringBuilder();
        for (char c : newChars) {
            builder.append(c);
        }
        return builder.toString();
    }

    private static String replaceBlankWithStringBuilder(String original) {
        StringBuilder builder = new StringBuilder();
        char[] chars = original.toCharArray();
        for (char c : chars) {
            builder.append(c == ' ' ? "%20" : c);
        }
        return builder.toString();
    }

}
