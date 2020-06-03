package me.zhang.offer;

/**
 * Created by zhangxiangdong on 2017/9/7.
 * <p>
 * 统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3, 3, 3, 4, 5}和数字3， 由于3在这个数组中出现了4次，因此输出4.
 */
public class Q38 {

    /**
     * 时间复杂度O(n)。
     *
     * @param a 排序数组
     * @param k 要查找的数
     * @return k出现的次数，没有则返回0
     */
    public static int getNumberOfK(int[] a, int k) {
        int index = binarySearch(a, k);
        int count = 0;
        int left = index, right = index + 1;
        while (left >= 0) {
            if (a[left] != k) {
                break;
            }
            left--;
            count++;
        }
        while (right < a.length) {
            if (a[right] != k) {
                break;
            }
            right++;
            count++;
        }
        return count;
    }

    /**
     * 返回k在排序数组中的下标（数组中可能有多个k）
     *
     * @param a 排序数组
     * @param k 要查找的数
     * @return 找到的数的下标，没有找到则返回-1
     */
    private static int binarySearch(int[] a, int k) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (k < a[mid]) {
                hi = mid - 1;
            } else if (k == a[mid]) {
                return mid;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 时间复杂度O(logn)。
     *
     * @param a 排序数组
     * @param k 要查找的数
     * @return k出现的次数，没有则返回-1
     */
    private static int getNumberOfKEfficiently(int[] a, int k) {
        if (a == null) {
            throw new NullPointerException();
        }

        int firstK = getFirstK(a, k, 0, a.length - 1);
        int lastK = getLastK(a, k, 0, a.length - 1);
        if (firstK > -1 && lastK > -1) {
            // 只有一个k则返回1
            return lastK - firstK + 1;
        }
        return 0;
    }

    private static int getFirstK(int[] a, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (a[mid] == k) {
            if ((mid > 0 && a[mid - 1] != k) || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (a[mid] < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getFirstK(a, k, start, end);
    }

    private static int getLastK(int[] a, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (a[mid] == k) {
            if ((mid < a.length - 1 && a[mid + 1] != k) || mid == a.length - 1) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (a[mid] < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getLastK(a, k, start, end);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 3, 4, 5};
        int k = 3;
        int count = getNumberOfK(a, k);
        System.out.println("Number of " + k + ": " + count);

        count = getNumberOfKEfficiently(a, k);
        System.out.println("Number of " + k + ": " + count);
    }

}
