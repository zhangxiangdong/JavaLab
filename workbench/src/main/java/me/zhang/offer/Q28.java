package me.zhang.offer;

/**
 * Created by Zhang on 8/20/2017 11:10 AM.
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排序。
 * 例如输入字符串abc，则打印出由字符a,b,c所能排列出来的所有字符串：abc,acb,bac,bca,cab,cba。
 */
public class Q28 {

    void permutation(String string) {
        if (string == null) {
            return;
        }
        char[] strArray = string.toCharArray();
        int begin = 0;
        permutation(strArray, begin);
    }

    private void permutation(char[] str, int begin) {
        if (begin == str.length) {
            System.out.println(str);
        } else {
            for (int i = begin; i < str.length; i++) {
                char temp = str[i];
                str[i] = str[begin];
                str[begin] = temp;
                System.out.println("Before: " + String.valueOf(str) + ", begin: " + begin + ", i: " + i);
                permutation(str, begin + 1);
                temp = str[i];
                str[i] = str[begin];
                str[begin] = temp;
                System.out.println("After: " + String.valueOf(str) + ", begin: " + begin + ", i: " + i);
            }
        }
    }

    public static void main(String[] args) {
        Q28 q28 = new Q28();
        q28.permutation("abc");
    }

}
