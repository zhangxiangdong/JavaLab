package me.zhang.array;

/**
 * Created by Zhang on 2015/11/23 上午 10:59 .
 */
public class OrdArray {

    private long[] a;
    private int nElems;

    public OrdArray(int size) {
        a = new long[size];
        nElems = 0;
    }

    public void insert(long value) { // put element into array
        int j;
        for (j = 0; j < nElems; j++) { // find where value goes
            if (value < a[j]) // linear search
                break;
        }
        for (int k = nElems; k > j; k--) { // move bigger ones up
            a[k] = a[k - 1];
        }
        a[j] = value; // insert it
        nElems++; // increment size
    }

    public void insertWithBinarySearch(long value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (lowerBound > upperBound) {
                System.out.println("lowerBound: " + lowerBound + ", upperBound: " + upperBound);
                // found the insert position: lowerBound
                // move bigger ones up
                for (int i = nElems; i > lowerBound; i--) {
                    a[i] = a[i - 1];
                }
                a[lowerBound] = value;
                nElems++;
                return;
            } else {
                if (a[curIn] < value)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    public boolean delete(long searchKey) {
        int targetIn = find(searchKey);
        if (targetIn == nElems)
            return false; // can't find it
        else { // found it
            for (int i = targetIn; i < nElems; i++) { // move bigger ones down, overwrite target key
                a[i] = a[i + 1];
            }
            nElems--; // decrement size
            return true;
        }
    }

    public int find(long searchKey) {
        /* init searching range */
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn; // found it
            } else if (lowerBound > upperBound) { // can't find it
                return nElems;
            } else { // divide range
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1; // it's in upper half
                } else {
                    upperBound = curIn - 1; // it's in lower half
                }
            }
        }
    }

    public int size() {
        return nElems;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
