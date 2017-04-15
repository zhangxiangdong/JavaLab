package me.zhang.array;

/**
 * Created by Zhang on 2015/11/20 下午 5:25 .
 */
public class HighArray {

    private long[] a;
    private int nElems;

    public HighArray(int size) {
        a = new long[size];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems++] = value;
    }

    public boolean delete(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey) {
                break;
            }
        }

        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;

        }
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey)
                break;
        }
        if (j == nElems)
            return false;
        else
            return true;
    }

    public long getMax() {
        if (nElems == 0)
            return -1;
        long max = a[0];
        for (int i = 0; i < nElems; i++) {
            if (max < a[i])
                max = a[i];
        }
        return max;
    }

    public long removeMax() {
        long max = getMax();
        delete(max);
        return max;
    }

    public void noDup() {
        long placeHolder = -1;
        if (nElems == 0)
            return;
        int n = 0;
        for (int i = 0; i < nElems; i++) {
            for (int j = i + 1; j < nElems; j++) {
                if (a[i] == a[j] && a[i] != -1) {
                    a[j] = placeHolder; // assume all numbers are positive
                    n++;
                }
            }
        }
        System.out.println("n = " + n);
        display();
        // remove all placeHolder, and shrink array length
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < nElems; i++) {
                if (a[i] == placeHolder) {
                    // delete placeHolder
                    for (int j = i; j < nElems; j++) {
                        a[j] = a[j + 1];
                    }
                    nElems--;
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
