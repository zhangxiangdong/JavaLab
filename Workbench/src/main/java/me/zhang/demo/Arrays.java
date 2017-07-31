package me.zhang.demo;

public class Arrays {

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(java.util.Arrays.toString(test));
        reverse(test);
        System.out.println(java.util.Arrays.toString(test));
    }

    static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

}
