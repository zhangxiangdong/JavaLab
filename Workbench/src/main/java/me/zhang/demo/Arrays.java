package me.zhang.demo;

public class Arrays {

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(java.util.Arrays.toString(test));

        System.out.println("After Reverse: ");
        reverse(test);
        System.out.println(java.util.Arrays.toString(test));

        System.out.println("Selection Sort: ");
        selectionSort(test);
        System.out.println(java.util.Arrays.toString(test));

        System.out.println("After Reverse: ");
        reverse(test);
        System.out.println(java.util.Arrays.toString(test));

        System.out.println("Bubble Sort: ");
        bubbleSort(test);
        System.out.println(java.util.Arrays.toString(test));

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8, 9};
        int[] r = concatenate(a, b);
        System.out.println("Merge Result: ");
        System.out.println(java.util.Arrays.toString(r));

        System.out.println("After Reverse: ");
        reverse(r);
        System.out.println(java.util.Arrays.toString(r));


        System.out.println("Quick Sort: ");
        quickSort(r, 0, r.length - 1);
        System.out.println(java.util.Arrays.toString(r));

        int[] rotated = new int[]{1, 2, 3, 4, 5, 7};
        System.out.println(java.util.Arrays.toString(rotated));
        int minIndex = minNumberInRotatedArray(rotated, 0, rotated.length - 1);
        System.out.printf("Min Number Index In Rotated Array: %d\n", minIndex);

        rotated = new int[]{4, 5, 6, 7, 1, 2, 3};
        minIndex = minNumberInRotatedArray(rotated, 0, rotated.length - 1);
        System.out.printf("Min Number Index In Rotated Array: %d\n", minIndex);

        rotated = new int[]{1, 0, 1, 1, 1};
        minIndex = minNumberInRotatedArray(rotated, 0, rotated.length - 1);
        System.out.printf("Min Number Index In Rotated Array: %d\n", minIndex);
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

    static void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int p = partition(a, lo, hi);
            quickSort(a, lo, p);
            quickSort(a, p + 1, hi);
        }
    }

    private static int partition(int[] a, int lo, int hi) {
        int pivot = a[lo];
        int i = lo, j = hi;
        while (true) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i >= j) {
                return j;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    static int minNumberInRotatedArray(int[] a, int lo, int hi) {
        if (lo >= hi) {
            throw new IllegalArgumentException();
        }
        // If the first number is greater than the last one,
        // it means that the array was sorted,
        // just returns the first index immediately.
        int target = lo;
        while (a[lo] >= a[hi]) {
            if (lo + 1 == hi) {
                target = hi;
                break;
            }

            int midIndex = (lo + hi) >>> 1;

            // {0, 1, 1, 1, 1} 旋转 {1, 0, 1, 1, 1}
            if (a[lo] == a[hi] && a[hi] == a[midIndex]) {
                // 顺序查找最小值的位置
                return minIndexInOrder(a);
            }

            if (a[lo] < a[midIndex]) {
                lo = midIndex;
            } else if (a[midIndex] < a[hi]) {
                hi = midIndex;
            }
        }
        return target;
    }

    private static int minIndexInOrder(int[] a) {
        int target = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[target] > a[i]) {
                target = i;
            }
        }
        return target;
    }

}
