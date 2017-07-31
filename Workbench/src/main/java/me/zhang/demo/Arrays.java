package me.zhang.demo;

public class Arrays {

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(java.util.Arrays.toString(test));

        reverse(test);
        System.out.println(java.util.Arrays.toString(test));

        System.out.println("Selection Sort: ");
        selectionSort(test);
        System.out.println(java.util.Arrays.toString(test));

        reverse(test);

        System.out.println("Bubble Sort: ");
        bubbleSort(test);
        System.out.println(java.util.Arrays.toString(test));

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8, 9};
        int[] r = concatenate(a, b);
        System.out.println("Merge Result: ");
        System.out.println(java.util.Arrays.toString(r));
    }

    static int[] concatenate(int[] a, int[] b) {
        int[] r = new int[a.length + b.length];
        System.arraycopy(a, 0, r, 0, a.length);
        System.arraycopy(b, 0, r, a.length, b.length);
        return r;
    }

    static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            // 假设选中的元素是最小的
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    // 找到更小的值，记录其位置
                    minIndex = j;
                }
            }

            // 选中的值不是最小的，执行交换操作
            if (i != minIndex) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }

    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

}
